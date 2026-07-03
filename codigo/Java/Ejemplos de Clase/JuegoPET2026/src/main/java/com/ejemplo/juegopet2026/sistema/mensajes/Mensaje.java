/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.mensajes;

/**
 *
 * @author sebastian
 */
public class Mensaje {
    private int usuario;
    private Informacion datos;

    /**
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the detalles
     */
    public Informacion getInformacion() {
        return datos;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDatos(Informacion datos) {
        this.datos = datos;
    }
    
    
}
