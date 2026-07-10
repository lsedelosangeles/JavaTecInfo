/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.ets_uno_2026.ejemplos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sebastian
 */
public class Border extends JFrame{
    
    private JPanel pnlZonaUsuario;
    private JPanel pnlZonaJuego;
    
    private JPanel pnlBotonera;

    public Border() {
        configurar();
    }
    
    private void configurar(){
        //Tamaño de la ventana
        setSize(800,600); 
        //Comportamiento al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Posicionar la ventana en el centro de la pantalla
        setLocationRelativeTo(null);
        //Mostramos la ventana
        setVisible(true);
        //Agrego el layout manager
        setLayout( new BorderLayout() );
        
        //Creo un panel nuevo
        pnlZonaUsuario = new JPanel( new BorderLayout() );
        //Le agrego un borde a la 
        pnlZonaUsuario.setBorder(
                BorderFactory.
                createMatteBorder(0, 0, 0, 1, Color.black)
        );
        //Color de fondo
        pnlZonaUsuario.setBackground(Color.red);
        pnlZonaUsuario.setPreferredSize(
                new Dimension(200, 0)
        );
        add(pnlZonaUsuario, BorderLayout.WEST);
        
        
        pnlZonaJuego = new JPanel(new BorderLayout());
        pnlZonaJuego.setPreferredSize(
                new Dimension(600, 0)
        );
        pnlZonaJuego.setBackground(Color.green);
        add(pnlZonaJuego, BorderLayout.EAST);
        
        pnlBotonera = new JPanel();
        pnlBotonera.setBorder(
                BorderFactory.
                createMatteBorder(2, 0, 0, 0, Color.black)
        );
        pnlBotonera.setPreferredSize(
                new Dimension(0, 200)
        );
        pnlZonaUsuario.add(pnlBotonera, BorderLayout.SOUTH);
        
        
//        //Creo un botón
//        JButton boton1 = new JButton("Boton A");
//        //Le doy tamaño preferencial
//        boton1.setPreferredSize( new Dimension(200,200) );
//        add(boton1, BorderLayout.NORTH);
    }
    
    public static void main(String[] args) {
        new Border();
    }
}
