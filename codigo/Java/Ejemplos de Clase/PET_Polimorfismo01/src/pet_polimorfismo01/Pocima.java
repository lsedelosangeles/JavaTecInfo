/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pet_polimorfismo01;

/**
 *
 * @author sebastian
 */
public class Pocima extends Objeto {

    private int cura;
    
    public Pocima(String nombre, int cura) {
        super(nombre);
        this.cura = cura;
    }
    
    public void efecto(Personaje p){
        System.out.println(p.getNombre() + " ha usado " + this.getNombre());
        p.cambiarVida(cura);        
    }
    
    
    
}
