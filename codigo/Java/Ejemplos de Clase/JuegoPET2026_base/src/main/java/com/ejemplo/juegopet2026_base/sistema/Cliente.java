/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026_base.sistema;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author sebastian
 */
public class Cliente {
    
    private String urlServidor;
    private int puertoServidor;
    private Socket conexion;
    private PrintWriter salida;
    private BufferedReader entrada;

    public Cliente(String urlServidor, int puertoServidor) {
        this.urlServidor = urlServidor;
        this.puertoServidor = puertoServidor;
    }
    
    public void iniciar(){
        try {
            conexion = 
               new Socket(urlServidor, puertoServidor);
            salida = new PrintWriter(
                    conexion.getOutputStream()
            );
            
            entrada = new BufferedReader(
                    new InputStreamReader(
                            conexion.
                              getInputStream()
                    )
            );
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        new Cliente("192.168.4.105", 6666).iniciar();
    }
}
