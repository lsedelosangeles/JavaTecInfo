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
 *
 * @author sebastian
 */
public class InterpreteCliente {

    private Cliente cliente;

    public InterpreteCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Procesa un String recibido y lo pasa a un objeto de tipo Mensaje para
     * analizarse
     *
     * @param mensaje
     * @return
     */
    public Mensaje obtenerMensaje(String mensaje) {
        Mensaje recibido = new Gson().fromJson(mensaje, Mensaje.class);
        return recibido;
    }

    /**
     * Interpreta las respuestas del servidor
     *
     * @param respuesta
     */
    public void interpretarRespuesta(String respuesta) {
        Mensaje recibido = obtenerMensaje(respuesta);

        String accion = recibido.getInformacion().getAccion();
        String datos = recibido.getInformacion().getDatos();

        switch (accion) {
            case Informacion.LOGIN_OK:

                UUID sesion = UUID.fromString(datos);
                cliente.setSesion(sesion);
                cliente.setSesionIniciada(true);
                System.out.println("Sesion iniciada");
                break;
            case Informacion.USUARIO_ID:
                int id = Integer.parseInt(datos);
                cliente.getUsuario().setId(id);
                break;
            case Informacion.LOGIN_ERROR:
                System.out.println("Nombre de usuario incorrecto. Intenta de nuevo.");
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
