/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_10abr2026_metconstructor;

import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class Jugador {
    private String nombre;
    private ArrayList<Carta> mano = 
            new ArrayList<>();

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    public void recibirCarta(Carta x){
        mano.add(x);
        System.out.println
          (verNombre() + " tiene " + cantidadCartas());
    }
    
    public int cantidadCartas(){
        return mano.size();
    } 

    /**
     * @return the nombre
     */
    public String verNombre() {
        return nombre;
    }
    
    public void verMano(){
        System.out.println
         (verNombre() + " tiene:");
        for (Carta carta : mano) {
            carta.verCarta();
        }
    }
}
