/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg06abr2026_metconstructor;

/**
 *
 * @author sebastian
 */
public class Usuario {
    
    private String nombre;
    private int id;
    private Personaje p1;
    
    public Usuario(String nombreU, int idU){
        this.nombre = nombreU;
        this.id = idU;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    
}
