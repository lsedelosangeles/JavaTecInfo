/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ets_polimorfismo_herencia_ejemplo;

import java.util.Random;

/**
 *
 * @author sebastian
 */
public class Juego {
    //A - Valores Estáticos
    //  1 - Colores:
    static final int COLOR_ROJO = 0;
    static final int COLOR_AMARILLO = 1;
    static final int COLOR_VERDE = 2;
    static final int COLOR_AZUL = 3;
    static final int COLOR_NEGRO = 4;
    
    //  2 - Cartas Especiales:
    static final int CARTA_SALTEO = 10;
    static final int CARTA_REV = 11;
    static final int CARTA_LLEVA2 = 12;
    static final int CARTA_CAMBIO = 13;
    static final int CARTA_CB_LLEVA4 = 14;
    
    //  3 - Estados de la Partida
    static final int PARTIDA_ABIERTA = 0;
    static final int PARTIDA_EN_CURSO = 1;
    static final int PARTIDA_FINALIZADA = 2;
    
    
    //Funciones Auxiliares
    private Random alAzar = new Random();

    public int NumeroAlAzar(int limite){
        int numero = alAzar.nextInt(limite);
        
        return numero;
    }
}
