/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.utu.baseinterfazborderlayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author sebastian
 */
public class Ejercicio extends JFrame{
     
    private Dimension resolucion = Toolkit.getDefaultToolkit().getScreenSize();
    private int alto = (int) (resolucion.height * 0.75);
    private int ancho = (int) (resolucion.width * 0.75);
    
    private JPanel latDerecho;
    private JPanel latIzquierdo;
    private JPanel latInferiorDer;
    private JPanel latIzquierdoChat;
    private JPanel latIzquierdoChatLista;
    private JPanel latIzquierdoChatMensaje;
    private JPanel latIzquierdoBotonera;
    private JButton btnMenu;
    private JButton btnPersonaje;
    private JButton btnItems;
    private JButton btnUsuario;
    private JButton btnEnviarMensaje;
    private JTextField txtfMensaje;

    public Ejercicio() {
        configurar();
    }

    private void configurar(){
        setSize(ancho, alto);
        
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        BorderLayout gestor = new BorderLayout();
        getContentPane().setLayout(gestor);
        
        latDerecho = new JPanel( new BorderLayout() );
        Dimension dimLatDerecho = new Dimension( (int)(ancho*0.8) , 0);
        latDerecho.setPreferredSize(dimLatDerecho);
        latDerecho.setBackground(Color.red);
        getContentPane().add(latDerecho, BorderLayout.LINE_END);
        
        
        
        latIzquierdo = new JPanel( new BorderLayout() );
        latIzquierdo.setPreferredSize( new Dimension( (int)(ancho*0.2), 0) );
        latIzquierdo.setBackground(Color.GREEN);
        getContentPane().add(latIzquierdo, BorderLayout.WEST);
        
        latIzquierdoBotonera = new JPanel( new GridLayout(4,1));
        latIzquierdoBotonera.setPreferredSize( new Dimension( 0,(int)(alto*0.3) ) );
        latIzquierdoBotonera.setBackground(Color.white);
        latIzquierdo.add(latIzquierdoBotonera, BorderLayout.PAGE_END);
        
        btnMenu = new JButton("Menú");
        btnPersonaje = new JButton("Personaje");
        btnItems = new JButton("Items");
        btnUsuario = new JButton("Usuario");
        latIzquierdoBotonera.add(btnMenu);
        latIzquierdoBotonera.add(btnPersonaje);
        latIzquierdoBotonera.add(btnItems);
        latIzquierdoBotonera.add(btnUsuario);
        
        latIzquierdoChat = new JPanel(new BorderLayout());
        latIzquierdoChat.setPreferredSize( new Dimension(0, (int)(alto*0.66)) );
        latIzquierdoChat.setBackground(Color.ORANGE);
        latIzquierdo.add(latIzquierdoChat, BorderLayout.PAGE_START);
        
        latIzquierdoChatLista = new JPanel();
        latIzquierdoChatLista.setBackground(Color.white);
        latIzquierdoChatLista.setPreferredSize(new Dimension(0, (int)(alto*0.56))); //(int)(latIzquierdoChat.getHeight()*0.9)));
        latIzquierdoChat.add(latIzquierdoChatLista, BorderLayout.PAGE_START);
        
        latIzquierdoChatMensaje = new JPanel( new BorderLayout(5,5));
        latIzquierdoChatMensaje.setPreferredSize(new Dimension(0, (int)(alto*0.07)));
        latIzquierdoChatMensaje.setBackground(Color.CYAN);
        latIzquierdoChat.add(latIzquierdoChatMensaje, BorderLayout.PAGE_END);
        
        txtfMensaje = new JTextField();
        txtfMensaje.setPreferredSize( new Dimension((int)(ancho*0.15),20));
        latIzquierdoChatMensaje.add(txtfMensaje, BorderLayout.LINE_START);
        
        latInferiorDer = new JPanel( new BorderLayout() );
        Dimension dimInferiorIzq = new Dimension(0, 100);
        latInferiorDer.setPreferredSize(dimInferiorIzq);
        latInferiorDer.setBackground(Color.BLUE);
        latDerecho.add(latInferiorDer, BorderLayout.SOUTH);
        
        setMaximumSize( new Dimension(ancho,alto) );
        setResizable(false);
        getContentPane().validate();
        getContentPane().repaint();
    }
    
    
    
    public static void main(String[] args) {
        new Ejercicio();
    }
    
}
