/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polimorfismo_27abr2026_pet;

/**
 *
 * @author sebastian
 */
public class Accesorio extends Objeto{

    private int modVidaMax;
            
    public Accesorio(String nombre, 
            int modVidaMax) {
        super(nombre);
        this.modVidaMax = modVidaMax;
    }
    
    public void efecto(Personaje p){
        p.setVidaMaxMod(modVidaMax);
        System.out.println
        (p.getNombre() + " esta usando" + this.getNombre());
    }
    
}
