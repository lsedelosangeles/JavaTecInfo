/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pet_polimorfismo01;

/**
 *
 * @author sebastian
 */
public class PET_Polimorfismo01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Personaje p = new Personaje("Carmilla", 20, 10, 250);
        Accesorio a = new Accesorio("Capa", 0, 5);
        Accesorio b = new Accesorio("Daga", 8, 0);
        Pocima c = new Pocima("Poción básica", 10);
        
        
        
        p.verDatos();
        p.cambiarVida(-45);
        p.usarObjeto(a);
        p.usarObjeto(b);
        p.verDatos();
        p.usarObjeto(c);
        p.verDatos();
    }
    
}
