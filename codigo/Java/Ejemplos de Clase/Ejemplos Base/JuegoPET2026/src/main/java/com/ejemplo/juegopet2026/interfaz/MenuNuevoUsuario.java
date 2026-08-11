/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.interfaz;

import com.ejemplo.juegopet2026.Fuentes;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author sebastian
 */
public class MenuNuevoUsuario extends JDialog{
    
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JTextField txtNombre;

    Fuentes fuentes = new Fuentes();
    
    public MenuNuevoUsuario(JFrame ventanaPadre) {
        super(ventanaPadre, true);
        configurar();
    }
    
    private void configurar(){
        setSize(320,240);
        setLayout( new GridBagLayout());
        setResizable(false);
        setTitle("Nuevo Usuario");
        
        GridBagConstraints restricciones = new GridBagConstraints();
        restricciones.insets = new Insets(10,5,10,5);
        restricciones.fill = GridBagConstraints.HORIZONTAL;
        
        lblTitulo = new JLabel("Nuevo Usuario", SwingConstants.CENTER);
        lblTitulo.setFont(fuentes.fntBotonesMd);
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.gridwidth = 2; // Ocupa las dos columnas
        add(lblTitulo, restricciones);
        
        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fuentes.fntBotonesCh);
        restricciones.gridx = 0;
        restricciones.gridy = 1;
        restricciones.gridwidth = 1;
        add(lblNombre, restricciones);
        
        txtNombre = new JTextField();
        txtNombre.setFont(fuentes.fntChat);
        restricciones.gridx = 1;
        restricciones.gridy = 1;
        add(txtNombre,restricciones);
        
        //pack();
    }
    
}
