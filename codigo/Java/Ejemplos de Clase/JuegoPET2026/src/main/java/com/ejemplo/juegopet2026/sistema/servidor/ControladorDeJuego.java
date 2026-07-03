/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.servidor;

import com.ejemplo.juegopet2026.basededatos.Consultas;
import com.ejemplo.juegopet2026.juego.Usuario;
import com.ejemplo.juegopet2026.sistema.mensajes.Informacion;
import com.ejemplo.juegopet2026.sistema.mensajes.Mensaje;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Establece las funciones que pueden realizar los clientes
 * @author sebastian
 */
public class ControladorDeJuego {
    
    private Servidor servidor;
    
    private ArrayList<GestorDeClientes> clientes = new ArrayList<>();

    Consultas consultas = new Consultas();
    
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
                String nombreUsuario = solicitudP.getInformacion().getDatos().split(":")[1];
                
                Usuario usuarioCliente = consultas.buscarUsuario(nombreUsuario);
                
                Mensaje respuesta = new Mensaje();
                respuesta.setUsuario(0);
                
                Informacion info = new Informacion();
                
                if (usuarioCliente != null) {
                    UUID sesion = UUID.randomUUID();
                    info.setAccion(Informacion.LOGIN_OK);
                    info.setDatos( 
                            "idSesion:" + sesion.toString() + 
                            ":idUsuario:" + usuarioCliente.getId() +
                            ":nombreUsuario:" + nombreUsuario);
                    cliente.setSesion(sesion);
                    
                }
                else{
                    info.setAccion(Informacion.LOGIN_ERROR);
                    
                }
                
                
                respuesta.setDatos(info);
                cliente.enviarMensaje(respuesta);
                
                break;
            case Informacion.MENSAJE:
                servidor.registrarMensaje("Mensaje enviado desde " + cliente.ipCliente());
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
        System.out.println("Cerrando conexiones... controlador");
        for (GestorDeClientes cliente : clientes) {
            System.out.println("Cerrando a " + cliente.ipCliente());
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
