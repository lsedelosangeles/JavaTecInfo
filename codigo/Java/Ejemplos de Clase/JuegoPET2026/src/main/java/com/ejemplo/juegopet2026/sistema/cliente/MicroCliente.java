/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.cliente;

import com.ejemplo.juegopet2026.sistema.mensajes.Informacion;
import com.ejemplo.juegopet2026.sistema.mensajes.Mensaje;



/**
 *
 * @author sebastian
 */
public class MicroCliente {
    
    private Cliente cliente;

    public MicroCliente() {
        cliente = new Cliente("192.168.2.58", 6666);
        cliente.iniciarConexion();
        
        cliente.login("fulano");
        
        cliente.enviarMensaje("hola");
    }
    
    
    
    public static void main(String[] args) {
        MicroCliente mc = new MicroCliente();
        
    }
}
