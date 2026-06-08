/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uno_imagencarta_29may2026;

import java.net.URL;

/**
 *
 * @author sebastian
 */
public class UNO_imagenCarta_29may2026 {
    
    Baraja b = new Baraja();
    
    public void chequear(){
        for (Carta c:b.getCartas()) {
            System.out.print(c.ruta());
            URL recurso = getClass().getResource(c.ruta());
            if (recurso != null) {
                System.out.println(" --->EXISTE");
            }
            else{
                System.out.println(" --->NO EXISTE");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        UNO_imagenCarta_29may2026 u =  new UNO_imagenCarta_29may2026();
        u.chequear();
        
    }
    
}
