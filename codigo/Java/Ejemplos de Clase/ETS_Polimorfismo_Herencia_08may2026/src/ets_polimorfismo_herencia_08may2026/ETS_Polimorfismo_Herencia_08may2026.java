/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ets_polimorfismo_herencia_08may2026;

/**
 *
 * @author sebastian
 */
public class ETS_Polimorfismo_Herencia_08may2026 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carta uno = new Carta(0, "rojo");
        Carta dos = new CartaNegra();
        
        uno.efecto();
        dos.efecto();
    }
    
}
