/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg06abr2026_metconstructor;

/**
 *
 * @author sebastian
 */
public class Personaje {
    private String nombre;
    private String raza;

    public Personaje(String nombre, String raza) {
        this.nombre = nombre;
        this.raza = raza;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }
    
    
}
