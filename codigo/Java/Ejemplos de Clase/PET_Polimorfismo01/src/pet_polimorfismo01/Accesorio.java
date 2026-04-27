/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pet_polimorfismo01;

/**
 *
 * @author sebastian
 */
public class Accesorio extends Objeto{
    
    private int modAtaque;
    private int modDefensa;

    public Accesorio(String nombre, int modAtaque, int modDefensa) {
        super(nombre);
        this.modAtaque = modAtaque;
        this.modDefensa = modDefensa;
    }
    
    public void efecto(Personaje p){
        if (modAtaque != 0) {
            p.setModAtaque(modAtaque);
        }
        
        if (modDefensa != 0) {
            p.setModDefensa(modDefensa);
        }
        
    }
}
