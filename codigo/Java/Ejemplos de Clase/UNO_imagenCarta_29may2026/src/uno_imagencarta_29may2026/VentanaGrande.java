/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_imagencarta_29may2026;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author sebastian
 */
public class VentanaGrande extends JFrame{
    
    Baraja baraja = new Baraja();

    public VentanaGrande() {
        configurar();
    }
    
    
    
    private void configurar(){
        setSize(1380, 250);
        GridLayout cuadricula = new GridLayout(4,27,2,2);
        getContentPane().setLayout(cuadricula);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        for (Carta carta : baraja.getCartas()) {
            PanelCarta cartita = new PanelCarta(carta);
            getContentPane().add(cartita);
        }
        
    }
    
    public static void main(String[] args) {
        VentanaGrande ventana = new VentanaGrande();
    }
    
}
