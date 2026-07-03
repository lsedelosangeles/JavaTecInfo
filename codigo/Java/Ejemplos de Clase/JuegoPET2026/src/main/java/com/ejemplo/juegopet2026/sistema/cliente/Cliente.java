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

/**
 *
 * @author sebastian
 */
public class Cliente implements Runnable{
    
    private String urlServidor;
    private int puertoServidor;
    private Socket conexion;
    private PrintWriter salida;
    private BufferedReader entrada;
    
    private SolicitudesCliente solicitudes;
    
    private volatile boolean activo;
    private UUID sesion;
    private Usuario usuario;

    public Cliente(String urlServidor, int puertoServidor) {
        this.urlServidor = urlServidor;
        this.puertoServidor = puertoServidor;
    }
    
    public void iniciarConexion(){
        try {
            conexion = new Socket(getUrlServidor(), getPuertoServidor());
            
            salida = new PrintWriter(getConexion().getOutputStream(), true);
            
            InputStreamReader lectorDeStream = new InputStreamReader(getConexion().getInputStream());               
            entrada = new BufferedReader(lectorDeStream);
            
            activo = true;
            
            new Thread(this).start();
            
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
       
    }
    
    /**
     * Envia un mensaje al servidor
     * @param solicitud 
     */
    public void enviarSolicitud(Mensaje solicitud) {
        
        String mensaje = new Gson().toJson(solicitud, Mensaje.class);
        
        if (salida != null) {
            System.out.println("Enviando: " + mensaje);
            salida.println(mensaje);
        }
    }
    
    
    
    public void login(String nombreUsuario){
        enviarSolicitud( solicitudes.loginUsuario(nombreUsuario) );
    }
    
    
    
    /**
     * Dentro del método run() se implementan las acciones que se pasan al hilo secundario, que se inician al ejecutar s
     */
    @Override
    public void run() {
        try {
            String mensajeEntrante;
            InterpreteCliente interprete = new InterpreteCliente(this);
            
            while (activo && (mensajeEntrante = entrada.readLine()) != null) {
                System.out.println("Esperando respuestas...");
                final String mensajeRecibido = mensajeEntrante;
                System.out.println("recibido: " + mensajeEntrante);
                
                //Se procesa e interpreta el mensaje recibido
                interprete.interpretarMensaje(mensajeRecibido);
            }
            
        } catch (Exception e) {
            System.err.println("ERROR (run): " + e.getMessage());
        }
    }
    
    public void desconectar() {
        activo = false;
        sesion = null;
        try {
            if (entrada != null) entrada.close();
            if (salida != null) salida.close();
            if (conexion != null && !conexion.isClosed()) conexion.close();
        } catch (IOException e) {
            e.printStackTrace();
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
    
    
    
}
