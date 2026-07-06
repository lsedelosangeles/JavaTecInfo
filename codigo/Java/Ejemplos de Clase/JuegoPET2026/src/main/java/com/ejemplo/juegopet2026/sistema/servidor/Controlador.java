/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.servidor;

import com.ejemplo.juegopet2026.basededatos.Consultas;
import com.ejemplo.juegopet2026.juego.Usuario;
import com.ejemplo.juegopet2026.sistema.mensajes.Informacion;
import com.ejemplo.juegopet2026.sistema.mensajes.Mensaje;
import com.ejemplo.juegopet2026.sistema.mensajes.RespuestasServidor;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Establece las funciones que pueden realizar los clientes
 *
 * @author sebastian
 */
public class Controlador {

    private Servidor servidor;

    //Clientes conectados
    private ArrayList<ClienteConectado> clientes = new ArrayList<>();

    Consultas consultas = new Consultas();
    RespuestasServidor respuestas = new RespuestasServidor();

    public Controlador(Servidor servidor) {
        this.servidor = servidor;
    }

    /**
     * Interpreta las solicitudes recibidas de los clientes
     *
     * @param solicitud
     * @param cliente
     */
    public synchronized void procesarSolicitud(String solicitud, ClienteConectado cliente) {
        Mensaje solicitudP = new Gson().fromJson(solicitud, Mensaje.class);

        String accion = solicitudP.getInformacion().getAccion();

        switch (accion) {
            case "LOGIN":
                login(solicitudP, cliente);
                break;
            case Informacion.MENSAJE:
                servidor.registrarMensaje("Mensaje enviado desde " + cliente.verIP());

                String nombreUsuario = solicitudP.getInformacion().getDatos().split(":")[1];

                Usuario usuarioCliente = consultas.buscarUsuario(nombreUsuario);

                for (ClienteConectado otroCliente : getClientes()) {
                    if (!(otroCliente.getSesion().equals(cliente.getSesion()))) {
                        otroCliente.enviarMensaje(solicitudP);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    // ACCIONES DE RESPUESTA A LOS MENSAJES
    
    /**
     * Respuesta a una solicitud de login
     * @param solicitud
     * @param cliente 
     */
    private void login(Mensaje solicitud, ClienteConectado cliente) {
        Mensaje respuesta = null;
        
        servidor.registrarMensaje("Solicitud de Login desde " + cliente.verIP());
        
        String nombreUsuario = solicitud.getInformacion().getDatos().split(":")[1];

        Usuario usuarioCliente = consultas.buscarUsuario(nombreUsuario);

        if (usuarioCliente != null) {
            servidor.registrarMensaje("Login exitoso de " + usuarioCliente.getNombre());
            UUID sesion = UUID.randomUUID();
            respuesta = respuestas.loginExitoso(usuarioCliente, sesion);
            cliente.setSesion(sesion);
            cliente.setUsuario(usuarioCliente);
            servidor.actualizarUsuarios();
        } else {
            respuesta = respuestas.loginFallido();
        }

        cliente.enviarMensaje(respuesta);
    }
    
    private void logout(Mensaje solicitud, ClienteConectado cliente){
        Mensaje respuesta = null;
        
        servidor.registrarMensaje("Solicitud de Logout desde " + cliente.verIP());
        servidor.registrarMensaje(cliente.getUsuario().getNombre() + " ha salido");
        cliente.cerrarConexiones();
        clientes.remove(cliente);
    }

    // -- --- --- --- --- --- --- --- --- --
    /**
     * Añade un cliente al sistema.
     *
     * @param cliente
     */
    public void agregarCliente(ClienteConectado cliente) {
        this.getClientes().add(cliente);
    }

    public void cerrarConexiones() {
        System.out.println("Cerrando conexiones... controlador");
        for (ClienteConectado cliente : getClientes()) {
            System.out.println("Cerrando a " + cliente.verIP());
            cliente.cerrarConexiones();
        }
    }

    /**
     * Permite redirigir mensajes al servidor
     *
     * @param mensaje
     */
    public void registrarMensaje(String mensaje) {
        servidor.registrarMensaje(mensaje);
    }

    /**
     * @return the clientes
     */
    public ArrayList<ClienteConectado> getClientes() {
        return clientes;
    }

}
