/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.mensajes;

import com.ejemplo.juegopet2026.juego.Usuario;

/**
 *
 * @author sebastian
 */
public class SolicitudesCliente extends Solicitudes{
    
    
    public Mensaje loginUsuario(String nombre){
        Mensaje msj = crearMensaje();
        
        msj.getInformacion().setAccion(Informacion.LOGIN);
        msj.getInformacion().setDatos(nombre);
        
        msj.setUsuario(-1);
        
        return msj;
    }
    
    public Mensaje enviarMensaje(String mensaje, Usuario remitente){
        Mensaje msj = crearMensaje();
        
        msj.setUsuario(remitente.getId());
        msj.getInformacion().setAccion(Informacion.MENSAJE);
        msj.getInformacion().setDatos(mensaje);
        
        return msj;
    }
    
    
    /**
     * Solicita el cierre de la sesión
     * @param remitente
     * @return 
     */
    public Mensaje logout(Usuario remitente){
        Mensaje msj = crearMensaje();
        
        msj.setUsuario(remitente.getId());
        msj.getInformacion().setAccion(Informacion.LOGOUT);
        
        return msj;
    }
}
