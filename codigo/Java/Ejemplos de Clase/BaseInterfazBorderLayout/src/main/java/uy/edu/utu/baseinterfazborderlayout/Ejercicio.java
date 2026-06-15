/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.utu.baseinterfazborderlayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
    private JPanel latInferiorIzq;
    

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
        
        latInferiorIzq = new JPanel( new BorderLayout() );
        Dimension dimInferiorIzq = new Dimension(0, 100);
        latInferiorIzq.setPreferredSize(dimInferiorIzq);
        latInferiorIzq.setBackground(Color.BLUE);
        latDerecho.add(latInferiorIzq, BorderLayout.SOUTH);
        
        setMaximumSize( new Dimension(ancho,alto) );
        setResizable(false);
    }
    
    public static void main(String[] args) {
        new Ejercicio();
    }
    
}
