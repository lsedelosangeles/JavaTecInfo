/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.cliente;

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
    
    public void interpretarMensaje(String mensaje){
        Mensaje recibido = obtenerMensaje(mensaje);
        
        String accion = recibido.getInformacion().getAccion();
        
        switch (accion) {
            case Informacion.LOGIN_OK:
                String idSesion = recibido.getInformacion().getDatos().split(":")[1];
                UUID sesion = UUID.fromString(idSesion);
                cliente.setSesion(sesion);
                
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
