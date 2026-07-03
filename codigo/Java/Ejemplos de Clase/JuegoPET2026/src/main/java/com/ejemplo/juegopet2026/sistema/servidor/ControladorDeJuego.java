/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.servidor;

import com.ejemplo.juegopet2026.sistema.mensajes.Informacion;
import com.ejemplo.juegopet2026.sistema.mensajes.Mensaje;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author sebastian
 */
public class ControladorDeJuego {
    
    private Servidor servidor;
    
    private ArrayList<GestorDeClientes> clientes = new ArrayList<>();

    public ControladorDeJuego(Servidor servidor) {
        this.servidor = servidor;
    }
    
    
    
    public synchronized void procesarSolicitud(String solicitud, GestorDeClientes cliente){
        Mensaje solicitudP = new Gson().fromJson(solicitud, Mensaje.class);
        
        String accion = solicitudP.getInformacion().getAccion();
        
        switch (accion) {
            case "LOGIN":
                //cliente.enviarMensaje("Probando login");
                servidor.registrarMensaje("Login desde " + cliente.ipCliente());
                
                Mensaje respuesta = new Mensaje();
                Informacion info = new Informacion();
                UUID sesion = UUID.randomUUID();
                info.setAccion(Informacion.LOGIN_OK);
                info.setDatos( "idSesion:"+sesion.toString() );
                
                respuesta.setDatos(info);
                cliente.enviarMensaje(respuesta);
                
                break;
            case Informacion.MENSAJE:
                for (GestorDeClientes otroCliente : clientes) {
                    if ( ! (otroCliente.getSesion().equals( cliente.getSesion() ) ) ) {
                        otroCliente.enviarMensaje(solicitudP);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
    }
    
    /**
     * 
     * @param cliente 
     */
    public void agregarCliente(GestorDeClientes cliente){
        this.clientes.add(cliente);
    }
    
    
    public void cerrarConexiones(){
        for (GestorDeClientes cliente : clientes) {
            cliente.cerrarConexiones();
        }
    }
    
    /**
     * Permite redirigir mensajes al servidor
     * @param mensaje 
     */
    public void registrarMensaje(String mensaje){
        servidor.registrarMensaje(mensaje);
    }
    
}
