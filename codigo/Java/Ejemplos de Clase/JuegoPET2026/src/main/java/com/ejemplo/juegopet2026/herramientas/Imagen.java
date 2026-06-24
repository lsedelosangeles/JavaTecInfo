/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.herramientas;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author sebastian
 */
public class Imagen {

    public ImageIcon agregarImagen(String rutaImagen, int ancho, int alto) {
        ImageIcon img = null;
        try {
            img = new ImageIcon(getClass().getResource(rutaImagen));
            Image ajuste = img.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            img = new ImageIcon(ajuste);
        } catch (Exception e) {
            System.err.println("Error al cargar imagen: " + e.getLocalizedMessage());
        }
        return img;
    }
    
}
