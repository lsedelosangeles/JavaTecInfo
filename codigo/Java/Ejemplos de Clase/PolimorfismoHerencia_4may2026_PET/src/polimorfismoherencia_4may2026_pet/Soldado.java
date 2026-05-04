/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polimorfismoherencia_4may2026_pet;

/**
 *
 * @author sebastian
 */
public class Soldado {
    
    private String nombre;
    private int ataque;

    public Soldado(String nombre, int ataque) {
        this.nombre = nombre;
        this.ataque = ataque;
    }
    
    public void atacar(){
        System.out.println
        (this.getNombre()+" hace "+ this.getAtaque()+ " de daño");
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the ataque
     */
    public int getAtaque() {
        return ataque;
    }
    
    
    
}
