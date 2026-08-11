/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026_base.sistema;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
            System.err.println("ERROR Cliente: " 
                    + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        Scanner teclado = 
                new Scanner(System.in);
        String servidor = "";
        System.out.println("IP del Servidor:");
        servidor = teclado.nextLine();
        
        Cliente c1 = 
                new Cliente(servidor, 6666);
        c1.iniciar();
        
        String mensaje="";
        while (! mensaje.equals("/salir")) {            
            System.out.print(">>: ");
            mensaje = teclado.nextLine();
            c1.enviarMensaje(mensaje);
        }
    }
    
    
    public void enviarMensaje(String mensaje){
        System.out.println(" ->");
        salida.println(mensaje);
    }
        
}
