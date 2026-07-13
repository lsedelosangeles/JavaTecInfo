/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.servidor;

import com.ejemplo.juegopet2026.juego.Usuario;
import com.ejemplo.juegopet2026.sistema.mensajes.Informacion;
import com.ejemplo.juegopet2026.sistema.mensajes.Mensaje;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;

/**
 * Esta clase representa a un Cliente conectado al sistema
 *
 * @author sebastian
 */
public class ClienteConectado implements Runnable {

    private Socket conexion;
    private BufferedReader entrada;
    private PrintWriter salida;
    private Controlador controlador;
    private UUID sesion = null;
    private Usuario usuario = null;

    public ClienteConectado(Socket conexion, Controlador controlador) throws IOException {
        this.conexion = conexion;
        this.controlador = controlador;

        //Inicializamos los objetos de envío y recepción de datos
        this.entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));;
        this.salida = new PrintWriter(conexion.getOutputStream(), true);

    }

    @Override
    public void run() {
        // Esta sección maneja las solicitudes que llegan 
        try {
            String mensajeEntrante;

            while ((mensajeEntrante = entrada.readLine()) != null) {
                controlador.procesarSolicitud(mensajeEntrante, this);
                System.out.println("--> " + mensajeEntrante);

            }

        } catch (IOException e) {
            controlador.registrarMensaje("Cliente desconectado desde " + conexion.getInetAddress().getCanonicalHostName());
        } finally {
            cerrarConexiones();
        }
    }

    /**
     * Envía las respuestas del servidor al cliente, sin formatear a JSON
     *
     * @param mensajeSaliente
     */
    public void enviarMensaje(String mensajeSaliente) {
        salida.println(mensajeSaliente);
    }

    /**
     * Envía las respuestas del servidor al cliente, formatéandolo a JSON
     *
     * @param mensajeSaliente
     */
    public void enviarMensaje(Mensaje mensajeSaliente) {
        String mensaje = new Gson().toJson(mensajeSaliente, Mensaje.class);
        salida.println(mensaje);
    }

    /**
     * Muestra la IP desde donde se conectó el cliente
     *
     * @return
     */
    public String verIP() {
        return conexion.getInetAddress().getCanonicalHostName();
    }

    /**
     * Cierra las conexiones hacia el cliente
     */
    public void cerrarConexiones() {
        System.out.println("Cerrando conexiones... cliente");
        try {
            if (entrada != null) {
                entrada.close();
            }
            if (salida != null) {
                salida.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (IOException e) {
            System.err.println("ERROR: " + this.getClass().getName() + ": " + e.getMessage());
        }
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
}
