/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto01;

/**
 *
 * @author sebastian
 */

import java.util.Random;

public class RuidoPerlin {
    
    
    private int[] p = new int[512];

    /**
     * Clase para generar una capa de ruido Perlin para la generación de mapas
     * @param semilla Base numérica para complementar el generador de valores
     * al azar.
     */
    public RuidoPerlin(long semilla) {
        //Declaramos un objeto para generar números al azar
        Random rand = new Random(semilla);
        
        for (int i = 0; i < 256; i++) p[i] = i;
        // Mezclamos el array (Fisher-Yates shuffle)
        for (int i = 255; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = p[i];
            p[i] = p[j];
            p[j] = temp;
        }
        for (int i = 0; i < 256; i++) p[256 + i] = p[i];
    }

    /**
     * Genera un valor de ruido para poblar un mapa
     * @param x coordenada en X de la posición del mapa
     * @param y coordenada en Y de la posición del mapa
     * @return 
     */
    public double noise(double x, double y) {
        int X = (int) Math.floor(x) & 255;
        int Y = (int) Math.floor(y) & 255;
        x -= Math.floor(x);
        y -= Math.floor(y);
        double u = fade(x);
        double v = fade(y);
        int aa = p[p[X] + Y], ab = p[p[X] + Y + 1], ba = p[p[X + 1] + Y], bb = p[p[X + 1] + Y + 1];
        return lerp(v, lerp(u, grad(p[aa], x, y), grad(p[ba], x - 1, y)),
                       lerp(u, grad(p[ab], x, y - 1), grad(p[bb], x - 1, y - 1)));
    }

    //Funciones auxiliares
    
    private double fade(double t) { return t * t * t * (t * (t * 6 - 15) + 10); }
    private double lerp(double t, double a, double b) { return a + t * (b - a); }
    private double grad(int hash, double x, double y) {
        int h = hash & 3;
        double u = h < 2 ? x : y;
        double v = h < 2 ? y : x;
        return ((h & 1) == 0 ? u : -u) + ((h & 2) == 0 ? v : -v);
    }
}
