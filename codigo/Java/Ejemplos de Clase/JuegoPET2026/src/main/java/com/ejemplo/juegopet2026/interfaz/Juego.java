/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.interfaz;

import com.ejemplo.juegopet2026.juego.Partida;
import com.ejemplo.juegopet2026.juego.Usuario;
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
public class Juego extends JFrame {
    
    Partida partida = null;

    private Dimension resolucion = Toolkit.getDefaultToolkit().getScreenSize();
    private int alto = (int) (resolucion.height * 0.85);
    private int ancho = (int) (resolucion.width * 0.85);

    private String titulo;
    
    private JPanel pnlIzquierdo;
    private JPanel pnlDerecho;
    
    private PanelMenu pnlMenu;
    private PanelChat pnlChat;

    /**
     * Crea y configura la ventana del juego
     */
    public Juego(String titulo) {
        configurar();
        
        //Se evalúa el título de la ventana y se lo establece
        titulo = titulo.strip();
        if (titulo.isEmpty()) {
            setTitle("El Juego");
        }
        else{
            setTitle(titulo);
        }
    }

    /**
     * Método para configurar la ventana principal
     */
    private void configurar() {
        //Configurar ventana principal
        setSize(ancho, alto);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(ancho, alto));
        setResizable(false);
        
        //Configurar panel de contenido
        getContentPane().setLayout(new BorderLayout());
        
        //Configurar sub-paneles
        // Izquierdo: Chat y Menú principal
        pnlIzquierdo = new JPanel(new BorderLayout());
        pnlIzquierdo.setPreferredSize(new Dimension((ancho/4),0));
        
        //  Se le agrega un borde al panel. BorderFactory es una clase que permite definir
        //  diferentes tipos de bordes a varios tipos de componentes. un MatteBorder permite
        //  bordes de distinto espesor para cada lado del componente. 
        //  En este caso, el borde solo aparece del lado derecho.
        pnlIzquierdo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        //  Se agrega el panel al Content pane de este JFrame.
        getContentPane().add(pnlIzquierdo, BorderLayout.LINE_START);
        
        //Paneles personalizados
        pnlChat = new PanelChat((int)(alto*0.7));
        pnlIzquierdo.add(pnlChat, BorderLayout.PAGE_START);
        
        pnlMenu = new PanelMenu((int)(alto*0.25));
        pnlIzquierdo.add(pnlMenu, BorderLayout.PAGE_END);
        
        // Derecho: Tablero y Barra de Estado/Botonera
        pnlDerecho = new JPanel(new BorderLayout());
        pnlDerecho.setPreferredSize(new Dimension( (3*(ancho/4) ), 0));
        getContentPane().add(pnlDerecho, BorderLayout.LINE_END);
        
        //Recalculamos y revalidamos los contenidos para asegurarnos que se muestran correctamente
        getContentPane().validate();
        getContentPane().repaint();
        
    }

    public static void main(String[] args) {
        new Juego("");
    }

}
