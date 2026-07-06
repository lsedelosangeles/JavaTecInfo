/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.cliente;

import com.ejemplo.juegopet2026.juego.Usuario;
import com.ejemplo.juegopet2026.sistema.mensajes.Informacion;
import com.ejemplo.juegopet2026.sistema.mensajes.Mensaje;
import com.google.gson.Gson;
import java.util.UUID;

/**
 * Esta clase procesa e interpreta los mensajes recibidos desde el servidor
 * @author sebastian
 */
public class InterpreteCliente {
    
    private Cliente cliente;

    public InterpreteCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    /**
     * Procesa un String recibido y lo pasa a un objeto de tipo Mensaje para analizarse
     * @param mensaje
     * @return 
     */
    public Mensaje obtenerMensaje(String mensaje){
        Mensaje recibido = new Gson().fromJson(mensaje, Mensaje.class);
        return recibido;
    }
    
    /**
     * Interpreta las respuestas del servidor
     * @param respuesta 
     */
    public void interpretarRespuesta(String respuesta){
        Mensaje recibido = obtenerMensaje(respuesta);
        
        String accion = recibido.getInformacion().getAccion();
        
        switch (accion) {
            case Informacion.LOGIN_OK:
                String[] datos = recibido.getInformacion().getDatos().split(":");
                
                int idUsuario = Integer.parseInt(datos[3]);
                String nombreUsuario = datos[5];
                cliente.setUsuario( new Usuario(nombreUsuario, idUsuario) );
                        
                String idSesion = datos[1];
                UUID sesion = UUID.fromString(idSesion);
                
                cliente.setSesion(sesion);
                cliente.setSesionIniciada(true);
                
                break;
            case Informacion.MENSAJE:
                //String usuario = 
                break;
            case Informacion.LOGOUT:
                System.out.println("Cerrando conexion por orden del servidor");
                cliente.desconectar();
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
}
