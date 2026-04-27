/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pet_polimorfismo01;

/**
 *
 * @author sebastian
 */
public class Personaje {
    private String nombre;
    private int ataque;
    private int modAtaque = 0;
    private int defensa;
    private int modDefensa = 0;
    private int vida;
    private int vidaMax;
    private int vidaMin = 1;

    public Personaje(String nombre, int ataque, int defensa, int vida) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
        this.vidaMax = vida;
    }
    
    public void verDatos(){
        System.out.println("Datos:");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Vida: " + vida + "/" + vidaMax);
        System.out.println("Defensa: " + defensa + "+" + modDefensa);
        System.out.println("Ataque: " + ataque + "+" + modAtaque);
        System.out.println("  ");
    }
    
    public void usarObjeto(Accesorio a){
        a.efecto(this);
    }
    
    public void usarObjeto(Pocima p){
        p.efecto(this);
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
    
    /**
     * @return the ataque
     */
    public int getAtaqueTotal() {
        return (ataque + modAtaque);
    }

    /**
     * @return the modAtaque
     */
    public int getModAtaque() {
        return modAtaque;
    }

    /**
     * @param modAtaque the modAtaque to set
     */
    public void setModAtaque(int modAtaque) {
        this.modAtaque = modAtaque;
    }

    /**
     * @return the defensa
     */
    public int getDefensa() {
        return defensa;
    }
    
    /**
     * @return the defensa
     */
    public int getDefensaTotal() {
        return (defensa + modDefensa);
    }

    /**
     * @return the modDefensa
     */
    public int getModDefensa() {
        return modDefensa;
    }

    /**
     * @param modDefensa the modDefensa to set
     */
    public void setModDefensa(int modDefensa) {
        this.modDefensa = modDefensa;
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
