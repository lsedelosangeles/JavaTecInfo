/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panelimagenes_pet_01jun2026;

import java.awt.HeadlessException;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InicioDos extends JFrame {
    private JLabel lblImagen;
    private String ruta 
            = "/imagen/20.png";

    public InicioDos(){
        configurar();
    }
    
    private void configurar(){
        this.setLayout(null);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            Image img = ImageIO.read
                    (getClass().getResource(ruta));
            Image imgChica = img.
                    getScaledInstance
                    (150, 150, Image.SCALE_SMOOTH);
            lblImagen = new JLabel
                    (new ImageIcon(imgChica));
            lblImagen.setBounds
                (5, 5, 150, 150);
            this.getContentPane().add(lblImagen);
            
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        InicioDos ventana = new InicioDos();
        ventana.setVisible(true);
    }
}
