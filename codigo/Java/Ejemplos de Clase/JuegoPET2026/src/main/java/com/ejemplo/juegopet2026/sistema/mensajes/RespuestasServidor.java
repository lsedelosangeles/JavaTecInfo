/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.mensajes;

import com.ejemplo.juegopet2026.juego.Usuario;
import java.util.UUID;

/**
 *
 * @author sebastian
 */
public class RespuestasServidor extends Solicitudes{
    
    /**
     * Crea un mensaje con la ID del servidor( siempre es 0)
     * @return
     */
    @Override
    public Mensaje crearMensaje(){
        Mensaje msj = super.crearMensaje();
        msj.setUsuario(0);
        return msj;
    }
    
    //public Mensaje mensajeDeUsuario(Mensaje entrante, Usuario remitente){
        
   // }
    
    
    /**
     * Respuesta a un login exitoso
     * @param destinatario
     * @param sesion
     * @return 
     */
    public Mensaje loginExitoso(Usuario destinatario, UUID sesion){
        Mensaje msj = crearMensaje();
        
        msj.getInformacion().setAccion(Informacion.LOGIN_OK);
        msj.getInformacion().setDatos(
                    "idSesion:" + sesion.toString()
                    + ":idUsuario:" + destinatario.getId()
                    + ":nombreUsuario:" + destinatario.getNombre());
        
        return msj;
    }
    
    /**
     * Respuesta a un login fallido
     * @return 
     */
    public Mensaje loginFallido(){
        Mensaje msj = crearMensaje();
        msj.getInformacion().setAccion(Informacion.LOGIN_ERROR);
        return msj;
    }
    
}
