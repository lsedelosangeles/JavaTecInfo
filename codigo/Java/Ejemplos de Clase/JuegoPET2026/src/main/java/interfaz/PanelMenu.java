/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author sebastian
 */
public class PanelMenu extends JPanel{
    
    private int alto;

    private JButton btnMenu;
    private JButton btnPersonaje;
    private JButton btnItems;
    private JButton btnUsuario;
    private Font fuente;
    
    public PanelMenu(int alto) {
        this.alto = alto;
        configurar();
    }
    
    private void configurar(){
        setLayout(new GridLayout(4, 1));
        setPreferredSize( new Dimension(0, alto) );
        
        try {
            fuente = new Font("Arial",Font.BOLD, 20);
        } catch (Exception e) {
            System.err.println("ERROR de Fuente: " + e.getMessage());
            fuente = new Font("Helvetica",Font.BOLD, 20);
        }
        
        btnMenu = new JButton("Menú");
        btnMenu.setFont(fuente);
        btnPersonaje = new JButton("Personaje");
        btnPersonaje.setFont(fuente);
        btnItems = new JButton("Items");
        btnItems.setFont(fuente);
        btnUsuario = new JButton("Usuario");
        btnUsuario.setFont(fuente);
        
        add(btnMenu);
        add(btnPersonaje);
        add(btnItems);
        add(btnUsuario);
        
        revalidate();
        repaint();
    }
    
}
