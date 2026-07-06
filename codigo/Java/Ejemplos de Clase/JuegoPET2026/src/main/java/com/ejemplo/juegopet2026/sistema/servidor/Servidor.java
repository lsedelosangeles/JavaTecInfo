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
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 *
 * @author sebastian
 */
public class Servidor implements Runnable {

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
    private Controlador controlador;  // Objeto que contiene la lógica base del juego y que gestiona las acciones del jugador

    
    /**
     * Permite crear el servidor y establecer sus atributos
     * @param puerto
     * @param ventana 
     */
    public Servidor(int puerto, Inicio ventana) {
        //Establecemos el puerto de conexión
        this.puerto = puerto;
        this.ventana = ventana;
        //Iniciamos el controlador
        this.controlador = new Controlador(this);
    }

    /**
     * Inicia el servidor del juego
     * @throws IOException 
     */
    public void iniciar() throws IOException {
        activo = true;

        ventana.registrarMensaje("Servidor ejecutándose en el puerto " + puerto);
        mostrarIp();
        conexionServidor = new ServerSocket(puerto);
        while (activo) {
            // Iniciamos las conexiones
              // Conexión del servidor a la red
            Socket conexionCliente = conexionServidor.accept();  // Conexión del cliente al servidor.

            // Si hay una conexión...
            ClienteConectado gestorClientes = new ClienteConectado(conexionCliente, controlador);
            ventana.registrarMensaje("Conexión entrante: " + conexionCliente.getInetAddress().getCanonicalHostName());
            
            controlador.agregarCliente(gestorClientes);
            // Creamos un hilo por cada cliente y le pasamos el controlador
            new Thread(gestorClientes).start();
        }
    }

    /**
     * Detiene el servidor
     */
    public void detener() {
        activo = false;
        ventana.registrarMensaje("ATENCIÓN: Cerrando el servidor");
        ventana.registrarMensaje("Cerrando conexiones a los clientes...");

        try {

            controlador.cerrarConexiones();
            System.out.println("Cerrando conexiones... servidor");
            ventana.registrarMensaje("Cerrando la conexión del servidor...");
            if (conexionServidor != null) {
                conexionServidor.close();
            }
            ventana.registrarMensaje("Servidor cerrado");
        } catch (IOException e) {
            ventana.registrarMensaje("ERROR al cerrar el servidor.");
            ventana.registrarMensaje("Detalle: " + e.getMessage());
        }
    }

    /**
     * Muestra las IPs disponibles para el servidor
     */
    private void mostrarIp() {
        // Source - https://stackoverflow.com/q/9481865
        // Posted by sasidhar, modified by community. See post 'Timeline' for change history
        // Retrieved 2026-07-03, License - CC BY-SA 3.0
        ventana.registrarMensaje("IPs del Servidor:");
        try {
            Enumeration interfacesDeRed = NetworkInterface.getNetworkInterfaces();

            while (interfacesDeRed.hasMoreElements()) {
                NetworkInterface interfazDeRed = (NetworkInterface) interfacesDeRed.nextElement();
                String nombreDeInterfaz = interfazDeRed.getDisplayName();
                ventana.registrarMensaje(" - " + nombreDeInterfaz + ": ");
                Enumeration listaDeIPs = interfazDeRed.getInetAddresses();

                while (listaDeIPs.hasMoreElements()) {
                    InetAddress ip = (InetAddress) listaDeIPs.nextElement();
                    ventana.registrarMensaje("\t" + ip.getCanonicalHostName());
                }
            }
        } catch (SocketException e) {
            System.err.println("ERROR al leer interfaces de red: " + e.getLocalizedMessage());
        }

    }

    /**
     * Libera los recursos y conexiones del servidor al cerrarse
     */
    private void liberarRecursos() {
        ventana.registrarMensaje("Limpiando y cerrando flujos de datos...");
        try {
            if (entrada != null) {
                entrada.close();
            }
            if (salida != null) {
                salida.close();
            }
           
            if (conexionServidor != null && !conexionServidor.isClosed()) {
                conexionServidor.close();
            }
            System.out.println("Servidor completamente cerrado y seguro.");
        } catch (IOException e) {
            System.out.println("Error liberando recursos: " + e.getMessage());
        }
    }

    /**
     * Redirije mensajes hacia la ventana
     *
     * @param mensaje
     */
    public void registrarMensaje(String mensaje) {
        ventana.registrarMensaje(mensaje);
    }

    public void actualizarUsuarios(){
        ventana.actualizarListaDeUsuarios(controlador.getClientes());
    }
    
    
    /**
     * Arranque del hilo del servidor
     */
    @Override
    public void run() {
        try {
            iniciar();
        } catch (SocketException se) {
            ventana.registrarMensaje("Se ha cerrado la conexión del servidor.");
            ventana.registrarMensaje("Detalle: " + se.getMessage());
        } catch (IOException ex) {
            ventana.registrarMensaje("ERROR: " + ex.getMessage());
        } finally {
            liberarRecursos();
        }
    }

}
