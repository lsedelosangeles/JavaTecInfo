/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author sebastian
 */
public class Ejemplo17jul2026 extends JFrame {
    private JButton btn1, btn2, btn3, btn4, btn5;

    public Ejemplo17jul2026() {
        configurar();
        
    }
    
    private void configurar(){
        setSize(800, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout( new BorderLayout());
        
        Dimension dimBase = new Dimension(150, 150);
        
        btn1 = new JButton("boton 1");
        btn1.setPreferredSize(dimBase);
        add(btn1, BorderLayout.EAST);
        
        btn2 = new JButton("boton 2");
        btn2.setPreferredSize(dimBase);
        add(btn2, BorderLayout.WEST);
        
        btn3 = new JButton("boton 3");
        btn3.setPreferredSize(dimBase);
        add(btn3, BorderLayout.NORTH);
        
        btn4 = new JButton("boton 4");
        btn4.setPreferredSize(dimBase);
        add(btn4, BorderLayout.SOUTH);
        
        btn5 = new JButton("boton 5");
        btn5.setPreferredSize(dimBase);
        add(btn5, BorderLayout.CENTER);
        
    }
    
    public static void main(String[] args) {
        
        new Ejemplo17jul2026();
    }
}
