/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.cliente;

import com.ejemplo.juegopet2026.sistema.mensajes.Informacion;
import com.ejemplo.juegopet2026.sistema.mensajes.Mensaje;
import java.util.Scanner;

/**
 *
 * @author sebastian
 */
public class MicroCliente {

    private Cliente cliente = null;

    public MicroCliente() {
        Scanner teclado = new Scanner(System.in);

        while (cliente == null) {
            System.out.println("Ingrese la IP del servidor:");

            String servidor = teclado.nextLine();

            cliente = new Cliente("localhost", 6666);
            //cliente = new Cliente("192.168.2.58", 6666);
            cliente.iniciarConexion();
            if(! cliente.isConectado()){
                cliente.desconectar();
                cliente = null;
            }
        }

        while (!cliente.haySesion()) {
            System.out.println("Ingrese un nombre de usuario:");
            String nombreUsuario = teclado.nextLine();
            cliente.login(nombreUsuario);
        }

        String mensaje = "";

        while (!mensaje.equals("salir")) {
            mensaje = teclado.nextLine();
            if (!mensaje.equals("salir")) {
                cliente.enviarMensaje("-" + mensaje);
            }
        }
        System.out.println("Cerrando la sesión");
        cliente.logout();
        teclado.close();
    }

    public static void main(String[] args) {
        MicroCliente mc = new MicroCliente();

    }
}
