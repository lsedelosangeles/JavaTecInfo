/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_10abr2026_metconstructor;

/**
 *
 * @author sebastian
 */
public class Carta {
    
    private int numero;
    private int color;
    
    
    public Carta(int numCarta, int colorCarta){
        this.color = colorCarta;
        this.numero = numCarta;
        
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
    
    
    public void verCarta(){
        String tipo="";
        String color_="";
        String resultado="";
        
        switch (this.color) {
            case Valores.COLOR_ROJO:
                color_ = "Rojo";
                break;
            case Valores.COLOR_AZUL:
                color_ = "Azul";
                break;
            case Valores.COLOR_NEGRO:
                color_ = "Negro";
                break;
            case Valores.COLOR_AMARILLO:
                color_ = "Amarillo";
                break;
            case Valores.COLOR_VERDE:
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
        System.out.println(resultado);
    }
}
