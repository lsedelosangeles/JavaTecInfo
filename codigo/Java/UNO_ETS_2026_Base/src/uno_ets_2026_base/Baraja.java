/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_ets_2026_base;

import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class Baraja {
    private ArrayList<Carta> cartas = new ArrayList<>();
    
    public Baraja(){
        int id= 0;
        
        
    }
    
    public void verCartas(){
        for (Carta carta : cartas) {
            String color = "";
            switch (carta.getColor()) {
                case Juego.COLOR_ROJO:
                    color = "rojo";
                    break;
                case Juego.COLOR_AZUL:
                    color = "azul";
                    break;
                case Juego.COLOR_AMARILLO:
                    color = "amarillo";
                    break;
                case Juego.COLOR_VERDE:
                    color = "verde";
                    break;
                case Juego.COLOR_NEGRO:
                    color = "negro";
                    break;
                default:
                    throw new AssertionError();
            }
                      
            System.out.println("N:" + carta.getNumero() + " - " + color + " - " + carta.getId());
        }
    }
}
