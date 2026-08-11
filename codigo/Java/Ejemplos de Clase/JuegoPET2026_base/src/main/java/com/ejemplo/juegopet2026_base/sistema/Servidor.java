/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026_base.sistema;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class Servidor implements Runnable{
    private ServerSocket conexionServidor;
    private int puerto;
    private volatile boolean activo = false;
    private String nombre;
    private ArrayList<ClienteConectado> clientes =
            new ArrayList<>();

    public Servidor(int puerto, String nombre) {
        this.puerto = puerto;
        this.nombre = nombre;
    }
    
    public void iniciar() throws IOException{
        activo = true;
        conexionServidor = new ServerSocket(puerto);
        System.out.println("Servidor iniciado");
        while (activo) {            
            Socket conexionCliente = 
                    conexionServidor.accept();
            System.out.println(
                    "Cliente conectado desde "+
                     conexionCliente.
                             getInetAddress().
                             getCanonicalHostName()
                    );
            ClienteConectado cliente = 
                    new ClienteConectado(conexionCliente);
            //Para agregar
            //cliente.enviarMensaje("Bienvenidos a " + nombre);
            //
            clientes.add(cliente);
            
            new Thread(cliente).start();
        }
    }

    @Override
    public void run() {
        try {
            iniciar();
        } 
        catch(SocketException se){
            System.out.println
                ("Se ha cerrado el servidor");
        }
        catch (IOException e) {
            System.err.println
                ("ERROR:"+e.getMessage());
        } 
    }
    
    public static void main(String[] args) {
        
        try {
            new Servidor(6666, "ElRicoServer").iniciar();
        } catch (IOException ex) {
            System.getLogger(Servidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
