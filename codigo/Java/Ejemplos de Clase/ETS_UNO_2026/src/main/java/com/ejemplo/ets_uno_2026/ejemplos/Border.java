/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.ets_uno_2026.ejemplos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author sebastian
 */
public class Border extends JFrame{

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
        
        //Creo un botón
        JButton boton1 = new JButton("Boton A");
        //Le doy tamaño preferencial
        boton1.setPreferredSize( new Dimension(200,200) );
        add(boton1, BorderLayout.NORTH);
    }
    
    public static void main(String[] args) {
        new Border();
    }
}
