/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polimorfismoherencia_4may2026_pet;


public class Lancero extends Soldado {

    public Lancero(String nombre, int ataque) {
        super(nombre, ataque);
    }
    
    @Override
    public void atacar(){
        System.out.println
        (getNombre()+" hace " + (getAtaque()+10));
    }
    
}
