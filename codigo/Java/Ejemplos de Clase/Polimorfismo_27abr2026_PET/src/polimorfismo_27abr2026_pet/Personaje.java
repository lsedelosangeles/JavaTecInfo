/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polimorfismo_27abr2026_pet;

/**
 *
 * @author sebastian
 */
public class Personaje {
    private String nombre;
    private int vida;
    private int vidaMax;
    private int vidaMaxMod = 0;
    
    
    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMax = vida;
    }
    
    
}
