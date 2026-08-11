/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.uno_ets_2026.sistema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author sebastian
 */
public class Cliente {
    private String urlServidor;
    private int puerto;
    private Socket conexion;
    private PrintWriter salida;
    private BufferedReader entrada;

    public Cliente(String url, int puerto){
            this.urlServidor = url;
            this.puerto = puerto;
    }
    
    public void conectar(){
        try {
            conexion =
                    new Socket(urlServidor, puerto);
            salida = new PrintWriter(
                    conexion.getOutputStream()
            );
            
            entrada = new BufferedReader(
                new InputStreamReader(
                    conexion.getInputStream()
                )
            );
            
        } catch (IOException ex) {
            System.getLogger(Cliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public static void main(String[] args) {
        new Cliente("192.168.0.112", 6666).conectar();
    }
}
