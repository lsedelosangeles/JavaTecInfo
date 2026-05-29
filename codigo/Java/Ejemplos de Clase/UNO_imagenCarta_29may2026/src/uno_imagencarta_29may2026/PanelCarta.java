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

    public PanelCarta(Carta carta) {
        this.carta = carta;
        configurar();
    }
    
    
    private void configurar(){
        this.setSize(80, 150);
        this.setBackground(Color.red);
        
        int id = carta.verId();
        int num = carta.verNumero();
        int color = carta.verColor();
        String ruta = "/imagen/"
                + id + "-" 
                + num + "-" 
                + color +".png";
        
        ImageIcon imagenPNG;
        JLabel imagen;
        
        try {
            imagenPNG = new ImageIcon(
                    getClass().getResource(ruta)
            );
            
            Image imagenPNGchica = 
                    imagenPNG.getImage().
                    getScaledInstance
                    (120, 180, Image.SCALE_SMOOTH);
            
            imagenPNG = new ImageIcon(imagenPNGchica);
            
            imagen = new JLabel(imagenPNG);
            add(imagen);
        } 
        catch (Exception error) {
            System.err.println(
                    "ERROR:" + error.getMessage()
            );
        }
        
        
        
    }
}
