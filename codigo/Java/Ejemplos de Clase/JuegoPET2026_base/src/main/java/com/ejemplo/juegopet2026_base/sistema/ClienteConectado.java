/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026_base.sistema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author sebastian
 */
public class ClienteConectado implements Runnable{
    private Socket conexion;
    private BufferedReader entrada;
    private PrintWriter salida;

    public ClienteConectado(Socket conexion)
            throws IOException
    {
        this.conexion = conexion;
        
        this.entrada = new BufferedReader(
                new InputStreamReader(
                        conexion.getInputStream()
                )
        );
        
        this.salida = new PrintWriter(
                conexion.getOutputStream()
        );
    }

    @Override
    public void run() {
        try {
            String mensajeEntrante;
            while ( 
                (mensajeEntrante=entrada.readLine())!=null
                    ) {                
                System.out.println("-> " + mensajeEntrante);
            }
        } catch (IOException e) {
            System.err.println
                ("ERROR:" + e.getMessage() );
        }
    }
    
    public void enviarMensaje(String mensaje){
        salida.println(mensaje);
    }
}
