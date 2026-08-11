/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.interfaz;

import com.ejemplo.juegopet2026.Fuentes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sebastian
 */
public class TarjetaMensaje extends JPanel {
    private String mensaje;
    private String usuario;
    
    private JLabel lblMensaje;
    private JLabel lblUsuario;
    
    Fuentes fuentes = new Fuentes();

    public TarjetaMensaje(String mensaje, String usuario) {
        this.mensaje = mensaje;
        this.usuario = usuario;
        configurar();
    }
    
    private void configurar(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.darkGray));
        setPreferredSize( new Dimension(150, 50));
        
        lblUsuario = new JLabel(usuario + ":");
        lblUsuario.setFont(fuentes.fntChatUsuario);
        add(lblUsuario, BorderLayout.PAGE_START);
        
        lblMensaje = new JLabel(mensaje);
        lblMensaje.setFont(fuentes.fntChat);
        add(lblMensaje, BorderLayout.PAGE_END);
    }
    
}
