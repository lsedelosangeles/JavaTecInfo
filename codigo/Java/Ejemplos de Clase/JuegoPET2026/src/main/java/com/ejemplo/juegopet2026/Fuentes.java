/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026;

import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author sebastian
 */
public class Fuentes {
    
    public Font fntBotonesCh;
    public Font fntBotonesMd;
    public Font fntBotonesGd;
    public Font fntChat;
    public Font fntChatUsuario;

    public Fuentes() {
        fntBotonesCh = cargarFuente("/fuentes/CarterOne-Regular.ttf", 20);
        fntBotonesMd = cargarFuente("/fuentes/CarterOne-Regular.ttf", 24);
        fntBotonesGd = cargarFuente("/fuentes/CarterOne-Regular.ttf", 30);
        fntChat = new Font("Arial", Font.PLAIN, 20);
        fntChatUsuario = new Font("Arial", Font.BOLD, 20);
    }
    
    private Font cargarFuente(String ruta, float tamanio){
        Font fuente;
        try {
            InputStream archivoFuente = getClass().getResourceAsStream(ruta);
            if (archivoFuente == null) {
                throw new IOException("No se encontró el recurso '" + ruta + "'");
            }
            
            fuente = Font.createFont(Font.TRUETYPE_FONT, archivoFuente);
            fuente = fuente.deriveFont(tamanio);
            
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            fuente =  new Font("Arial", Font.PLAIN, (int)tamanio);
        }
        
        return fuente;
    }
}
