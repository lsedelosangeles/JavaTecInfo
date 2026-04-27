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
public class Jugador {
    private String nombre;
    private int id;
    private int rango;
    
    private ArrayList<Carta> mano = new ArrayList<>();

    
    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    public void recibirCarta(Carta c){
        mano.add(c);
    }
    
    public int cartasEnMano(){
        System.out.println(getNombre() + " tiene " + mano.size());
        return mano.size();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the rango
     */
    public int getRango() {
        return rango;
    }
    
    
}
