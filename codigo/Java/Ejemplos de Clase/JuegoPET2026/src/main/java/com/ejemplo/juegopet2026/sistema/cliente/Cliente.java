/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.cliente;

import com.ejemplo.juegopet2026.juego.Usuario;
import com.ejemplo.juegopet2026.sistema.mensajes.Mensaje;
import com.ejemplo.juegopet2026.sistema.mensajes.SolicitudesCliente;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;
import javax.swing.JFrame;

/**
 *
 * @author sebastian
 */
public class Cliente implements Runnable {

    private String urlServidor;
    private int puertoServidor;
    private Socket conexion;
    private PrintWriter salida;
    private BufferedReader entrada;

    private MiniCliente ventana;

    private SolicitudesCliente solicitudes = new SolicitudesCliente();

    private volatile boolean conectado;
    private volatile boolean sesionIniciada;
    private String nombreServidor;
    private UUID sesion;
    private Usuario usuario;

    public Cliente(String urlServidor, int puertoServidor) {
        this.urlServidor = urlServidor;
        this.puertoServidor = puertoServidor;
        this.ventana = null;
    }

    public Cliente(String urlServidor, int puertoServidor, MiniCliente ventana) {
        this.urlServidor = urlServidor;
        this.puertoServidor = puertoServidor;
        this.ventana = ventana;
    }

    /**
     * Inicia la conexión del cliente al servidor
     */
    public void iniciarConexion() {
        try {
            conexion = new Socket(getUrlServidor(), getPuertoServidor());

            salida = new PrintWriter(getConexion().getOutputStream(), true);

            InputStreamReader lectorDeStream = new InputStreamReader(getConexion().getInputStream());
            entrada = new BufferedReader(lectorDeStream);

            setConectado(true);

            new Thread(this).start();

        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
            ventana.mostrarAviso("ERROR: " + e.getMessage());
        }

    }

    /**
     * Envia un mensaje al servidor
     *
     * @param solicitud
     */
    public void enviarSolicitud(Mensaje solicitud) {

        String mensaje = new Gson().toJson(solicitud, Mensaje.class);

        if (salida != null) {
            System.out.println("Enviando: " + mensaje);
            salida.println(mensaje);
        }
    }

    // SOLICITUDES DEL CLIENTE
    /**
     * Inicia el proceso de login en el servidor
     *
     * @param nombreUsuario
     */
    public void login(String nombreUsuario) {
        enviarSolicitud(solicitudes.loginUsuario(nombreUsuario));
        this.usuario = new Usuario(nombreUsuario);
    }

    public void logout() {
        enviarSolicitud(solicitudes.logout(usuario));
    }

    public void enviarMensaje(String mensaje) {
        if (sesionIniciada) {
            enviarSolicitud(solicitudes.enviarMensaje(mensaje, usuario));
        }
    }

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    /**
     * Dentro del método run() se implementan las acciones que se pasan al hilo
     * secundario, que se inician al ejecutar s
     */
    @Override
    public void run() {
        try {
            String mensajeEntrante;
            InterpreteCliente interprete = new InterpreteCliente(this);

            while (isConectado() && (mensajeEntrante = entrada.readLine()) != null) {
                System.out.println("Esperando respuestas...");
                final String mensajeRecibido = mensajeEntrante;
                System.out.println("recibido: " + mensajeEntrante);

                //Se procesa e interpreta el mensaje recibido
                interprete.interpretarRespuesta(mensajeRecibido);
            }

        } catch (Exception e) {
            System.err.println("ERROR (run): " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            if (salida != null) {
                salida.close();
            }
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //setConectado(false);
        sesionIniciada = false;
        sesion = null;
    }

    public void aviso(String mensaje) {
        if (ventana != null) {
            ventana.mostrarAviso(mensaje);
        }
    }

    /**
     * @return the urlServidor
     */
    public String getUrlServidor() {
        return urlServidor;
    }

    /**
     * @return the puertoServidor
     */
    public int getPuertoServidor() {
        return puertoServidor;
    }

    /**
     * @return the conexion
     */
    public Socket getConexion() {
        return conexion;
    }

    /**
     * @return the sesion
     */
    public UUID getSesion() {
        return sesion;
    }

    /**
     * @param sesion the sesion to set
     */
    public void setSesion(UUID sesion) {
        this.sesion = sesion;
        System.out.println("Sesión establecida a " + this.sesion.toString());
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the sesionIniciada
     */
    public boolean haySesion() {
        if (sesionIniciada) {
            System.out.println("Sesión iniciada");
        } else {
            System.out.println("Sesión cerrada");
        }
        return sesionIniciada;
    }

    /**
     * @param sesionIniciada the sesionIniciada to set
     */
    public void setSesionIniciada(boolean sesionIniciada) {
        this.sesionIniciada = sesionIniciada;
        if (sesionIniciada) {
            System.out.println("Sesión iniciada");
        } else {
            System.out.println("Sesión cerrada");
        }
    }

    /**
     * @return the conectado
     */
    public boolean isConectado() {
        if (conectado) {
            System.out.println("Cliente conectado");
        } else {
            System.out.println("Cliente desconectado");
        }
        return conectado;
    }

    /**
     * @param conectado the conectado to set
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
        if (conectado) {
            System.out.println("Cliente conectado");
        } else {
            System.out.println("Cliente desconectado");
        }
    }

    /**
     * @return the nombreServidor
     */
    public String getNombreServidor() {
        return nombreServidor;
    }

    /**
     * @param nombreServidor the nombreServidor to set
     */
    public void setNombreServidor(String nombreServidor) {
        this.nombreServidor = nombreServidor;
        ventana.cambiarNombreServidor(nombreServidor);
    }

}
