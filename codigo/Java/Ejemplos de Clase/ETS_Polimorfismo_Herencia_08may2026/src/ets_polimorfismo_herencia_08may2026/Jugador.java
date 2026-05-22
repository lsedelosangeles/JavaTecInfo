/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ets_polimorfismo_herencia_08may2026;

/**
 *
 * @author sebastian
 */
public abstract class Jugador {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }
    
    public abstract void crearPartida(); 
    
}
