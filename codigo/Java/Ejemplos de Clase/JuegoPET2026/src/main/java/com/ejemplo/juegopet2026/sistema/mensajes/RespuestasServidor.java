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
    
    
    public Mensaje bienvenida(String mensaje){
        Mensaje msj = crearMensaje();
        msj.getInformacion().setAccion(Informacion.BIENVENIDA);
        msj.getInformacion().setDatos("Conectado a " + mensaje);
        return msj;
    }
    
    
    public Mensaje darNombreServidor(String nombre){
        Mensaje msj = crearMensaje();
        msj.getInformacion().setAccion(Informacion.SERVIDOR_NOMBRE);
        msj.getInformacion().setDatos(nombre);
        return msj;
    }
    
    /**
     * Respuesta a un login exitoso
     * @param sesion
     * @return 
     */
    public Mensaje loginExitoso(UUID sesion){
        Mensaje msj = crearMensaje();
        
        msj.getInformacion().setAccion(Informacion.LOGIN_OK);
        msj.getInformacion().setDatos(sesion.toString());
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
    
    
    public Mensaje enviarIdUsuario(Usuario destinatario){
        Mensaje msj = crearMensaje();
        msj.getInformacion().setAccion(Informacion.USUARIO_ID);
        msj.getInformacion().setDatos(destinatario.getId()+"");
        return msj;
    }
    
    
    /**
     * Crea un mensaje para el chat general
     * @param mensaje
     * @param usuario
     * @return 
     */
    public Mensaje mensajeDeChat(String mensaje, Usuario usuario){
        Mensaje msj = crearMensaje();
        
        String contenido = usuario.getNombre() + ": " + mensaje;
        
        msj.getInformacion().setDatos(contenido);
        
        return msj;
    }
    
    public Mensaje desconectar(){
        Mensaje msj = crearMensaje();
        
        msj.getInformacion().setAccion(Informacion.LOGOUT);
        return msj;
    }
}
