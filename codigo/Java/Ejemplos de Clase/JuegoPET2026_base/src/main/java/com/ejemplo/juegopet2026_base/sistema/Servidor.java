/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026_base.sistema;

import java.net.ServerSocket;

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
    
    
}
