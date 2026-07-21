/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026_base.sistema;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sebastian
 */
public class Servidor {
    private ServerSocket conexionServidor;
    private int puerto;
    private volatile boolean activo = false;
    private String nombre;

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
        }
    }
    
}
