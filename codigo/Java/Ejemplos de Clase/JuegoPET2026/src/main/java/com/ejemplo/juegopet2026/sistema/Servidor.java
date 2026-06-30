/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema;

import com.ejemplo.juegopet2026.interfaz.servidor.Inicio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sebastian
 */
public class Servidor implements Runnable{
    //Atributos del sistema de red:
    // Objetos para recibir las conexiones de clientes
    private ServerSocket conexionServidor;
    private Socket conexionCliente;
    private int puerto;  // Puerto de red para recibir las conexiones
    
    private BufferedReader entrada; // Objeto para recibir solicitudes de los clientes
    private PrintWriter salida; // Objeto para enviar las respuestas del servidor
    
    private Thread hilo; // Permite derivar cada conexión a su propio hilo de ejecución
    
    private Inicio ventana;   //Referencia a la ventana para visualizar los eventos del servidor
    
    //Atributos del sistema del juego
    private ControladorDeJuego controlador;  // Objeto que contiene la lógica base del juego

    
    public Servidor(int puerto, Inicio ventana) {
        //Establecemos el puerto de conexión
        this.puerto = puerto;
        this.ventana = ventana;
        //Iniciamos el controlador
        this.controlador = new ControladorDeJuego();
    }
    
    
    public void iniciar() throws IOException {
        conexionServidor = new ServerSocket(puerto);
        conexionCliente = conexionServidor.accept();
        
        
        
        ventana.registrarMensaje("Servidor ejecutándose en el puerto " + puerto);
        
        while (true) {
            //Socket clientSocket = serverSocket.accept();
            // Creamos un hilo por cada cliente y le pasamos el controlador
            //ManejadorCliente cliente = new ManejadorCliente(clientSocket, controlador);
            //new Thread(cliente).start();
        }
    }
    
    @Override
    public void run(){
        
        try {
            iniciar();
        } catch (IOException ex) {
            ventana.registrarMensaje("ERROR: " + ex.getMessage());
            
        }
    }
    
    
}
