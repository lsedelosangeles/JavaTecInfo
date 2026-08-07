/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.uno_ets_2026.sistema;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class Servidor {
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
        
        while (activo) {            
            Socket conexionCliente =
                    conexionServidor.accept();
            System.out.println
                ("Se ha conectado un cliente");
            
            ClienteConectado nuevoCliente = 
            new ClienteConectado(conexionCliente);
            clientes.add(nuevoCliente);
            
            new Thread(nuevoCliente).start();
        }
    }
    
}
