/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_10abr2026_metconstructor;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 *
 * @author sebastian
 */
public class Baraja {
    private ArrayList<Carta> cartas 
            = new ArrayList<>();
    
    public Baraja(){
        int color = 0;
        int numero = 0;

        //Bucle para generar la baraja, primera parte
        for (int contador = 0; contador < 60; contador++) {
            //Creamos la carta, pero no le damos valor
            Carta x;

            //Chequeamos su número para ver si debe ser negra
            if (numero < 13) {
                x = new Carta
                    (numero, color);
            } else {
                x = new Carta
                    (numero, Valores.COLOR_NEGRO);
            }

            //Agregamos la carta a la baraja
            //baraja[contador] = x;
            cartas.add(x);

            if (numero < 14) {
                numero++;
            } else {
                numero = 0;

                if (color < 3) {
                    color++;
                }
            }
        }

        //Bucle para crear la baraja, 2da parte
        
        numero = 1;
        color = 0;
        
        for (int i = 60; i < 108; i++) {
            Carta x = 
               new Carta(numero, color);
            
            if (numero < 12) {
                numero++;
            } else {
                numero = 1;
                
                if (color < 3) {
                    color++;
                }
            }
            
            //baraja[i] = x;
            cartas.add(x);
        }
    }
    
    public void barajar(){
        Collections.shuffle(cartas);
    }
    
    public void verCartas(){
        
    }
}
