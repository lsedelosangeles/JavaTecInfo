/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.pet_interfazbase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *                
 * @author sebastian
 */
public class Tablero extends JFrame{

    private Dimension resolucion = 
            Toolkit.getDefaultToolkit().
            getScreenSize();
    
    private int ancho = 
            (int)(resolucion.width * 0.8);
    private int alto =
            (int)(resolucion.height * 0.8);
    
    public Tablero(){
        configurar();
    }
    
    private void configurar(){
        setSize(ancho,alto);
        setVisible(true);
        setLocationRelativeTo(null);
        
        //BorderLayout bl = new BorderLayout();
        getContentPane().
                setLayout( new BorderLayout() );
        
        JPanel col1 = new JPanel();
        col1.setBackground(Color.red);
        
        Dimension dimCol1 = 
            new Dimension(
                    (int)(ancho*0.25),0
                    );
        
        col1.setPreferredSize(dimCol1);
        
        getContentPane().
                add(col1,
                BorderLayout.LINE_START);
        
    }
    
    
    
    public static void main(String[] args) {
        Tablero t = new Tablero();
    }
}
