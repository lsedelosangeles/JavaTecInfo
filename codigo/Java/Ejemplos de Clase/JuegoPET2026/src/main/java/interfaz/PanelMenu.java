/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import com.ejemplo.juegopet2026.herramientas.Imagen;
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
    
    private Imagen imagen = new Imagen();
    
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
        
        btnMenu = new JButton("Menú", imagen.agregarImagen("/imagen/menu.png", 50, 50));
        btnMenu.setFont(fuente);
        btnMenu.setIconTextGap(50);
        
        btnPersonaje = new JButton("Personaje", imagen.agregarImagen("/imagen/silueta.png", 50, 50));
        btnPersonaje.setIconTextGap(50);
        btnPersonaje.setFont(fuente);
        
        btnItems = new JButton("Items", imagen.agregarImagen("/imagen/mochila.png", 50, 50));
        btnItems.setIconTextGap(50);
        btnItems.setFont(fuente);
        
        btnUsuario = new JButton("Usuario", imagen.agregarImagen("/imagen/usuario.png", 50, 50));
        btnUsuario.setIconTextGap(50);
        btnUsuario.setFont(fuente);
        
        add(btnMenu);
        add(btnPersonaje);
        add(btnItems);
        add(btnUsuario);
        
        revalidate();
        repaint();
    }
    
}
