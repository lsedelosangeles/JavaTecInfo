/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.interfaz;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
public class Dialogo {
    
    public static void mostrarAviso(String aviso){
        JOptionPane creadorDialogos = new JOptionPane( aviso, JOptionPane.INFORMATION_MESSAGE );
        
        JDialog dialogo = creadorDialogos.createDialog(null, "");
        dialogo.setModal(false);
        dialogo.setVisible(true);
    }
    
}
