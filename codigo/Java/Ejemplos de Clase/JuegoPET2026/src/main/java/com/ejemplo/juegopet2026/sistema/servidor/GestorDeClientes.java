/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.servidor;

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
 * @author sebastian
 */
public class GestorDeClientes implements Runnable{
    private Socket conexion;
    private BufferedReader entrada;
    private PrintWriter salida;
    private ControladorDeJuego controlador;
    private UUID sesion = null;

    public GestorDeClientes(Socket conexion, ControladorDeJuego controlador) throws IOException{
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
            
            while ( (mensajeEntrante = entrada.readLine()) != null ) {                
                controlador.procesarSolicitud(mensajeEntrante, this);
                System.out.println("--> " + mensajeEntrante);
                //enviarMensaje("recibido");
            }
            
        } catch (IOException e) {
            controlador.registrarMensaje("Cliente desconectado desde " + conexion.getInetAddress().getCanonicalHostName());
        }
        finally{
            cerrarConexiones();
        }
    }
    
    /**
     * Envía las respuestas del servidor al cliente
     * @param mensajeSaliente 
     */
    public void enviarMensaje(String mensajeSaliente){
        salida.println(mensajeSaliente);
    }
    
    public void enviarMensaje(Mensaje mensajeSaliente){
        String mensaje = new Gson().toJson(mensajeSaliente, Mensaje.class);
        salida.println(mensaje);
    }
    
    
    public String ipCliente(){
        return conexion.getInetAddress().getCanonicalHostName();
    }
    
    public void cerrarConexiones(){
        System.out.println("Cerrando conexiones... cliente");
        Mensaje solicitudC = new Mensaje();
        Informacion info = new Informacion();
        
        info.setAccion(Informacion.LOGOUT);
        solicitudC.setDatos(info);
        enviarMensaje(solicitudC);
        
        try {
            entrada.close();
            salida.close();
            conexion.close();
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
}
