/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pet.pkg20abr2026.encapsulamiento;

/**
 *
 * @author sebastian
 */
public class PET20abr2026Encapsulamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NPC p1 = new NPC(10, 5, 20, "Johan");
        NPC p2 = new NPC(9, 18, 22, "Ibrahim");
        
        System.out.println(p2.getVida());
        p1.atacar(p2);
        System.out.println(p2.getVida());
    }
    
}
