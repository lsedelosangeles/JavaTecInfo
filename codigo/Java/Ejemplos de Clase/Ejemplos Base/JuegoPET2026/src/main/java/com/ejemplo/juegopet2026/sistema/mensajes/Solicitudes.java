/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.mensajes;

/**
 *
 * @author sebastian
 */
public class Solicitudes {

    public Mensaje crearMensaje() {
        Mensaje msj = new Mensaje();
        Informacion info = new Informacion();
        msj.setDatos(info);
        return msj;
    }

}
