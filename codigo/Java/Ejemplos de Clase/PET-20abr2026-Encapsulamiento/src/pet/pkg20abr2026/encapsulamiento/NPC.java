/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pet.pkg20abr2026.encapsulamiento;

/**
 *
 * @author sebastian
 */
public class NPC {
    private String nombre;
    private int ataque;
    private int defensa;
    private int vida;
    private int vidaMax;
    private int vidaMin = 1;
    
    public NPC(int ataque, int defensa, 
            int vida, String nombre) {
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
        this.vidaMax = vida;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void atacar(NPC personaje){
        System.out.println
            (this.nombre + " ataca a " + 
                    personaje.getNombre());
        
        personaje.cambiarVida(this.ataque * -1);
    }

    /**
     * @return the ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * @return the defensa
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * @param defensa the defensa to set
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
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
