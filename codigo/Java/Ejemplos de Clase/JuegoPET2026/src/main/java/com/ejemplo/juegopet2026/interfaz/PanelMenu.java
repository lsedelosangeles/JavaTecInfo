/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.interfaz;

import com.ejemplo.juegopet2026.Fuentes;
import com.ejemplo.juegopet2026.herramientas.Imagen;
import com.ejemplo.juegopet2026.juego.Partida;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author sebastian
 */
public class PanelMenu extends JPanel{
    
    private Partida partida;
    
    private int alto;

    private JButton btnMenu;
    private JButton btnPersonaje;
    private JButton btnItems;
    private JButton btnUsuario;
    private Font fuente;
    Fuentes fuentes = new Fuentes();
    
    private Imagen imagen = new Imagen();
    
    public PanelMenu(int alto) {
        this.alto = alto;
        configurar();
    }
    
    private void configurar(){
        setLayout(new GridLayout(4, 1));
        setPreferredSize( new Dimension(0, alto) );
        
        btnMenu = new JButton("Menú", imagen.agregarImagen("/imagen/menu.png", 50, 50));
        btnMenu.setFont(fuentes.fntBotonesMd);
        btnMenu.setIconTextGap(50);
        
        btnPersonaje = new JButton("Personaje", imagen.agregarImagen("/imagen/silueta.png", 50, 50));
        btnPersonaje.setIconTextGap(50);
        btnPersonaje.setFont(fuentes.fntBotonesMd);
        
        btnItems = new JButton("Items", imagen.agregarImagen("/imagen/mochila.png", 50, 50));
        btnItems.setIconTextGap(50);
        btnItems.setFont(fuentes.fntBotonesMd);
        
        btnUsuario = new JButton("Usuario", imagen.agregarImagen("/imagen/usuario.png", 50, 50));
        btnUsuario.setIconTextGap(50);
        btnUsuario.setFont(fuentes.fntBotonesMd);
        btnUsuario.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenuUsuario();
            }
                }
        );
        
        add(btnMenu);
        add(btnPersonaje);
        add(btnItems);
        add(btnUsuario);
        
        revalidate();
        repaint();
    }
    
    private void abrirMenuUsuario(){
        //MenuUsuario mu = new MenuUsuario( (JFrame)SwingUtilities.getWindowAncestor(this) );
        //mu.setLocationRelativeTo(this);
        //mu.setVisible(true);
    }
    
    
    /**
     * Chequea el estado de la partida
     * @return 
     */
    private boolean chequearPartida(){
        boolean resultado = false;
        
        if (partida!=null) {
            resultado = true;
        }
        else{
            JOptionPane.showMessageDialog(this, "Inicia una partida primero", "Atención", JOptionPane.WARNING_MESSAGE);
        }
        
        return resultado;
    }
    
}
