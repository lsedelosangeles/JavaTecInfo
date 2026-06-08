/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_imagencarta_29may2026;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sebastian
 */
public class PanelCarta extends JPanel {
    private Carta carta;
    
    int ancho = 70;
    int alto = 100;

    public PanelCarta(Carta carta) {
        this.carta = carta;
        configurar();
    }
    
    
    private void configurar(){
        this.setLayout(null);
        this.setSize(ancho, alto);
        
        //this.setBackground(Color.red);
        
        
        String ruta = carta.ruta();
        //String ruta2 = "/imagen/0-0-0.png";
        ImageIcon imagenPNG;
        JLabel imagen;
        
        try {
            imagenPNG = new ImageIcon(
                    getClass().getResource(ruta)
            );
            
            Image imagenPNGchica = 
                    imagenPNG.getImage().
                    getScaledInstance
                    (ancho, alto, Image.SCALE_SMOOTH);
            
            imagenPNG = new ImageIcon(imagenPNGchica);
            imagen = new JLabel(imagenPNG);
            imagen.setBounds(0, 0, ancho, alto);
            add(imagen);
        } 
        catch (Exception error) {
            System.err.println(
                    "ERROR:" + error.getMessage()
            );
        }
        
        
        
    }
}
