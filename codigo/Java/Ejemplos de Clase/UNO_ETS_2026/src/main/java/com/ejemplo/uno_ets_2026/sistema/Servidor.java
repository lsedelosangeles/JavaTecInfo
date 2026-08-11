/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.uno_ets_2026.sistema;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class Servidor
        implements Runnable
    {
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
        conexionServidor = 
                new ServerSocket(puerto);
        
        System.out.println
        ("Servidor " +nombre+ " Iniciado");
        
        while (activo) {            
            Socket conexionCliente =
                    conexionServidor.accept();
            System.out.println
                ("Se ha conectado un cliente: " + 
                        conexionCliente
                                .getInetAddress()
                                .getCanonicalHostName()
                );
            
            ClienteConectado nuevoCliente = 
            new ClienteConectado(conexionCliente);
            clientes.add(nuevoCliente);
            
            new Thread(nuevoCliente).start();
        }
    }

    @Override
    public void run() {
        try {
            iniciar();
        }
        catch (SocketException e3) {
            System.err.println
        ("ERROR SOCKET:" + e3.getMessage());
        }
        catch (IOException e2) {
            System.err.println
        ("ERROR IO:" + e2.getMessage());
        }
        catch (Exception e1) {
            System.err.println
        ("ERROR:" + e1.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Servidor(6666, "ElRicoServer").run();
    }
}
