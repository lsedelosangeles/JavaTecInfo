/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iaita;

import java.util.Scanner;

/**
 *
 * @author sebastian
 */
public class IAita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un número");
        
        int entrada = 0;//teclado.nextInt();
        
        try {
            entrada = teclado.nextInt();
            if (entrada < 10) {
                System.out.println("Ese número es menor que 10");
            } else {
                System.out.println("Ese número no es menor que 10");
            }
        } catch (Exception e) {
            System.out.println("Eso no es un número");
        }
        
        
    }
    
}
