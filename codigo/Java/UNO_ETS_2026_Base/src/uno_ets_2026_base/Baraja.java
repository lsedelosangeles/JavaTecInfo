/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_ets_2026_base;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sebastian
 */
public class Baraja {
    private ArrayList<Carta> cartas = new ArrayList<>();
    
    public Baraja(){
        
        int id= 0;
        int color = 0;
        int numero = 0;

        //Bucle para generar la baraja, primera parte
        for (int contador = 0; contador < 60; contador++) {
            //Creamos la carta, pero no le damos valor
            Carta x;

            //Chequeamos su número para ver si debe ser negra
            if (numero < 13) {
                x = new Carta
                    (numero, color,contador);
            } else {
                x = new Carta
                    (numero, Juego.COLOR_NEGRO, contador);
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
               new Carta(numero, color, i);
            
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
    
    public void verCartas(){
        for (Carta carta : cartas) {
            System.out.println(carta.verCartaTodo());
        }
    }
    
    public void barajar(){
        Collections.shuffle(cartas);
//        Juego j = new Juego();
//        
//        for (int i = 0; i < 108; i++) {
//            int posAzar = j.NumeroAlAzar(108);
//            Carta carta1 = this.cartas.get(i);
//            Carta carta2 = this.cartas.get(posAzar);
//            this.cartas.set(i, carta2);
//            this.cartas.set(posAzar, carta1);
//        }
    }
    
    public Carta darCarta(){
        Carta c = cartas.getFirst();
        cartas.removeFirst();
        return c;
    }
    
    public int verCantidad(){
        System.out.println("Cartas: " + cartas.size() );
        return cartas.size();
    }
}
