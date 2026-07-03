/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.mensajes;

/**
 *
 * @author sebastian
 */
public class SolicitudesCliente {
    
    public Mensaje loginUsuario(String nombre){
        Mensaje msj = new Mensaje();
        Informacion info = new Informacion();
        
        info.setAccion(Informacion.LOGIN);
        info.setDatos("usuario:"+nombre);
        
        msj.setUsuario(0);
        msj.setDatos(info);
        
        return msj;
    }
    
}
