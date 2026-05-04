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
    private int defensa=0;
    
    
    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMax = vida;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @return the vidaMax
     */
    public int getVidaMax() {
        return vidaMax;
    }

    /**
     * @return the vidaMaxMod
     */
    public int getVidaMaxMod() {
        return vidaMaxMod;
    }

    /**
     * @param vidaMaxMod the vidaMaxMod to set
     */
    public void setVidaMaxMod(int vidaMaxMod) {
        this.vidaMaxMod = vidaMaxMod;
    }
    
    public void cambiarVida(int valor) {
        if(valor > 0){ // ¿Curamos o Dañamos?
            //Si curamos...
            if (vidaMax - vida > 0) { //¿Podemos curar algo?
                // ¿Cuánto podemos curar?
                
                if (valor <= (vidaMax - vida)) { 
                    vida = vida + valor;
                    System.out.println(nombre + " recupera " + valor + " puntos de daño");
                }
                else{
                    int cura = vidaMax - vida;
                    vida = vidaMax;
                    System.out.println(nombre + " recupera " + cura + " puntos de daño");
                }
            }
        }
        // Si dañamos
        else{
            int lesion = Math.min(0, defensa + valor);
            vida = vida + lesion;
            System.out.println(nombre + " recibe " + lesion + " puntos de daño");
        }
    }
    
    
}
