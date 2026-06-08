/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_imagencarta_29may2026;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author sebastian
 */
public class VentanaGrande extends JFrame {

    Baraja baraja = new Baraja();

    public VentanaGrande() {
        configurar();
    }

    private void configurar() {
        setSize(1900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout cuadricula = new GridLayout(4, 27, 2, 2);
        getContentPane().setLayout(cuadricula);
        //getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        baraja.barajar();
        //Carta c = new Carta(0,0,0);
        //PanelCarta cc = new PanelCarta(c);
        //cc.setBounds(0, 0, cc.ancho, cc.alto);
        //getContentPane().add(cc);
        for (Carta carta : baraja.getCartas()) {
            PanelCarta cartita = new PanelCarta(carta);
            getContentPane().add(cartita);
            try {
                Thread.sleep(100);
                getContentPane().revalidate();
                getContentPane().repaint();
            } catch (InterruptedException ex) {
                System.getLogger(VentanaGrande.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public static void main(String[] args) {
        VentanaGrande ventana = new VentanaGrande();

    }

}
