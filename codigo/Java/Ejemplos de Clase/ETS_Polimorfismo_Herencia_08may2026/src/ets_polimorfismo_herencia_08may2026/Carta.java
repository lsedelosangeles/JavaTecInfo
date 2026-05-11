/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ets_polimorfismo_herencia_08may2026;

/**
 *
 * @author sebastian
 */
public class Carta {
    private int numero;
    private String color;

    public Carta(int numero, String color) {
        this.numero = numero;
        this.color = color;
    }
    
    public void efecto(){
        System.out.println("Este es el efecto original");
    }
    
}
