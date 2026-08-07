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

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
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
    
    public void verDatos(){
        System.out.println("Datos del usuario:");
        System.out.println("\tNombre: " + nombre );
        System.out.println("\tID: " + id);
    }
    
    
}
