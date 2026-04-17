/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_ets_2026_base;

/**
 *
 * @author sebastian
 */
public class Carta {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    private int id = 0;
    private int numero = 0;
    private int color = 0;
    
    public Carta(int numero, int color, int id){
        this.numero = numero;
        this.color = color;
        this.id = id;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }
    
    
}
