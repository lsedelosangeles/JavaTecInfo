/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto01;

/**
 *
 * @author sebastian
 */
public class Herramientas {
    public static int alAzarEntre(int minimo, int maximo){
        int resultado = (int) Math.floor(Math.random() * (maximo - minimo +1) + minimo );
        return resultado;
    }
}
