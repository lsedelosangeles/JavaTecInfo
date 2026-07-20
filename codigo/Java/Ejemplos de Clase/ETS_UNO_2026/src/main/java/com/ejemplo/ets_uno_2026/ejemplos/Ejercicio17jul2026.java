/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.ets_uno_2026.ejemplos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sebastian
 */
public class Ejercicio17jul2026 extends JFrame{

    private JPanel pnlZonaUsuario, pnlZonaJuego;
    private JPanel pnlZonaChat, pnlBotonesUsuario, pnlChat, pnlMensajes;
    private JPanel pnlZonaJugador, pnlBotonesJuego, pnlMano;
    private JPanel pnlZonaJugador1, pnlZonaJugador2, pnlZonaJugador3, pnlMesaJuego; 
    
    private int ancho,alto;
    private int anchoZonaJuego, anchoZonaUsuario;
    private int altoZonaChat, altoBotonesUsuario, altoMensajes, altoChat;
    private int altoZonaJugador, anchoBotonesJuego, anchoMano;
    private int anchoZonaJugador2_3, altoZonaJugador1; 
    
    private Dimension resolucion = Toolkit.getDefaultToolkit().getScreenSize();
    
    public Ejercicio17jul2026(){
        configurar();
    }
    
    private void configurar(){
        ancho = (int)(resolucion.getWidth() * 0.8 ); //Establecemos el tamaño de la ventana al 80%
        alto = (int)(resolucion.getHeight() * 0.8 ); //  y lo convertimos a int
        
        //Configurar características generales de la ventana
        setSize(ancho, alto);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Jana");
        setVisible(true);
        
        //Configuración de las zonas básicas: Usuario y Juego
        anchoZonaJuego = (int)(ancho * 0.75);
        anchoZonaUsuario = ancho - anchoZonaJuego;
        
        //Zona del Usuario
        pnlZonaUsuario = new JPanel( new BorderLayout());
        pnlZonaUsuario.setPreferredSize( new Dimension(anchoZonaUsuario, 0) );
        pnlZonaUsuario.setBorder( BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black) );
        add(pnlZonaUsuario, BorderLayout.WEST);
        
        //Zona del Juego
        pnlZonaJuego = new JPanel( new BorderLayout());
        pnlZonaJuego.setPreferredSize( new Dimension(anchoZonaJuego, 0) );
        pnlZonaJuego.setBackground(Color.red);
        add(pnlZonaJuego, BorderLayout.EAST);
        
        //Elementos de la zona de Usuario
        altoBotonesUsuario = anchoZonaUsuario;
        altoZonaChat = alto - altoBotonesUsuario;
        
        //Zona del Chat
        pnlZonaChat = new JPanel(new BorderLayout());
        pnlZonaChat.setPreferredSize( new Dimension(0, altoZonaChat) );
        pnlZonaChat.setBorder( BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black) );
        pnlZonaUsuario.add(pnlZonaChat, BorderLayout.NORTH);
        
        //Zona de Botones del Usuario
        pnlBotonesUsuario = new JPanel();
        pnlBotonesUsuario.setPreferredSize( new Dimension(0,altoBotonesUsuario) );
        pnlBotonesUsuario.setBackground(Color.orange);
        pnlZonaUsuario.add(pnlBotonesUsuario, BorderLayout.SOUTH);
        
        //Elementos de la zona del Juego
        //anchoMano = (int)()
        
        pnlMano = new JPanel();
        //pnlMano
        
        
    }
    
    public static void main(String[] args) {
        new Ejercicio17jul2026();
    }
}
