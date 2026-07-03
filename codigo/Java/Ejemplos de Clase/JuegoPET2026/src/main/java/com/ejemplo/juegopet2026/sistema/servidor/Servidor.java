/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.servidor;

import com.ejemplo.juegopet2026.interfaz.servidor.Inicio;
import com.ejemplo.juegopet2026.juego.Usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class Servidor implements Runnable{
    //Atributos del sistema de red:
    // Objetos para recibir las conexiones de clientes
    private ServerSocket conexionServidor;
    private int puerto;  // Puerto de red para recibir las conexiones
    
    private volatile boolean activo = false; //  Este boolean permitirá controlar el bucle principal del servidor
    // El modificador 'volatile' asegura que el objeto sea visible entre los distintos hilos de ejecución iniciados
    
    private BufferedReader entrada; // Objeto para recibir solicitudes de los clientes
    private PrintWriter salida; // Objeto para enviar las respuestas del servidor
    
    private Thread hilo; // Permite derivar cada conexión a su propio hilo de ejecución
    
    private Inicio ventana;   //Referencia a la ventana para visualizar los eventos del servidor
    
    //Atributos del sistema del juego
    private ControladorDeJuego controlador;  // Objeto que contiene la lógica base del juego y que gestiona las acciones del jugador
    
    
    
    
    
    public Servidor(int puerto, Inicio ventana) {
        //Establecemos el puerto de conexión
        this.puerto = puerto;
        this.ventana = ventana;
        //Iniciamos el controlador
        this.controlador = new ControladorDeJuego(this);
    }
    
    
    public void iniciar() throws IOException {
        activo = true;
        
        ventana.registrarMensaje("Servidor ejecutándose en el puerto " + puerto);
        
        while (activo) {
            // Iniciamos las conexiones
            conexionServidor = new ServerSocket(puerto);  // Conexión del servidor a la red
            Socket conexionCliente = conexionServidor.accept();  // Conexión del cliente al servidor.
            
            // Si hay una conexión...
            GestorDeClientes gestorClientes = new GestorDeClientes(conexionCliente, controlador);
            ventana.registrarMensaje("Conexión entrante: " +  conexionCliente.getInetAddress().getCanonicalHostName());
            
            
            // Creamos un hilo por cada cliente y le pasamos el controlador
            new Thread(gestorClientes).start();
        }
    }
    
    
    /**
     * Detiene el servidor
     */
    public void detener(){
        activo = false;
        ventana.registrarMensaje("ATENCIÓN: Cerrando el servidor");
        ventana.registrarMensaje("Cerrando conexiones a los clientes...");
        
        try {
            
            controlador.cerrarConexiones();
            
            ventana.registrarMensaje("Cerrando la conexión del servidor...");
            if(conexionServidor != null){
                conexionServidor.close();
            }
            ventana.registrarMensaje("Servidor cerrado");
        } catch (IOException e) {
            ventana.registrarMensaje("ERROR al cerrar el servidor.");
            ventana.registrarMensaje("Detalle: " + e.getMessage());
        }
    }
    
    
    private void liberarRecursos() {
        ventana.registrarMensaje("Limpiando y cerrando flujos de datos...");
        try {
            if (entrada != null) entrada.close();
            if (salida != null) salida.close();
            //if (socketCliente != null && !socketCliente.isClosed()) socketCliente.close();
            if (conexionServidor != null && !conexionServidor.isClosed()) conexionServidor.close();
            System.out.println("Servidor completamente cerrado y seguro.");
        } catch (IOException e) {
            System.out.println("Error liberando recursos: " + e.getMessage());
        }
    }
    
   /**
    * Redirije mensajes hacia la ventana
    * @param mensaje 
    */
   public void registrarMensaje(String mensaje){
       ventana.registrarMensaje(mensaje);
   }
    
    @Override
    public void run(){
        try {
            iniciar();
        } 
        catch (SocketException se){
            ventana.registrarMensaje("Se ha cerrado la conexión del servidor.");
            ventana.registrarMensaje("Detalle: " + se.getMessage() + "\n" + se.getLocalizedMessage());
        }
        catch (IOException ex) {
            ventana.registrarMensaje("ERROR: " + ex.getMessage());
        }
        finally{
            liberarRecursos();
        }
    }
    
    
    
    
}
