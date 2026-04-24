/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_ets_2026_base;

/**
 *
 * @author sebastian
 */
public class Carta {

    private int id = 0;
    private int numero = 0;
    private int color = 0;
    
    public Carta(int numero, int color, int id){
        this.numero = numero;
        this.color = color;
        this.id = id;
    }
    
    /**
     * @return the id
     */
    public int verId() {
        return id;
    }

    /**
     * @return the numero
     */
    public int verNumero() {
        return numero;
    }

    /**
     * @return the color
     */
    public int verColor() {
        return color;
    }
    
    
    public String verCarta(){
        String tipo="";
        String color_="";
        String resultado="";
        
        switch (this.color) {
            case Juego.COLOR_ROJO:
                color_ = "Rojo";
                break;
            case Juego.COLOR_AZUL:
                color_ = "Azul";
                break;
            case Juego.COLOR_NEGRO:
                color_ = "Negro";
                break;
            case Juego.COLOR_AMARILLO:
                color_ = "Amarillo";
                break;
            case Juego.COLOR_VERDE:
                color_ = "Verde";
                break;
        }
        
        switch (this.numero) {
            case 10:
                tipo = "Bloqueo";
                break;
            case 11:
                tipo = "Reversa";
                break;
            case 12:
                tipo = "Más 2";
                break;
            case 13:
                tipo = "Cambia Color";
                break;
            case 14:
                tipo = "Más 4, Cambia Color";
                break;
            default:
                tipo = "" + numero;
        }
        
        resultado = tipo + " - " + color_;
        //System.out.println(resultado);
        return resultado;
    }
    
    public String verCartaTodo(){
        return this.id + " - " + verCarta();
    }
    
}
