/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ets_polimorfismo_herencia_08may2026;

/**
 *
 * @author sebastian
 */
public class CartaNegra extends Carta{

    public CartaNegra() {
        super(0, null);
    }

    @Override
    public void efecto() {
        System.out.println("Este es el efecto de carta negra"); 
    }
    
    
}
