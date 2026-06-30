/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.juego;

/**
 *
 * @author sebastian
 */
public class Usuario {
    private String nombre;
    private int id = 0;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    
    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    
}
