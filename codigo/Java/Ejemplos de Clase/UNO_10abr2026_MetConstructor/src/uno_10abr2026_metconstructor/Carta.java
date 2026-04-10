/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_10abr2026_metconstructor;

/**
 *
 * @author sebastian
 */
public class Carta {
    
    private int numero;
    private int color;
    
    
    public Carta(int numCarta, int colorCarta){
        this.color = colorCarta;
        this.numero = numCarta;
        
    }

    /**
     * @return the numero
     */
    public int verNumero() {
        return numero;
    }

    /**
     * @return the color
     */
    public int verColor() {
        return color;
    }
    
}
