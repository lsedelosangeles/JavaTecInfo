/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.interfaz;

import com.ejemplo.juegopet2026.Fuentes;
import com.ejemplo.juegopet2026.herramientas.Imagen;
import java.awt.Adjustable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author sebastian
 */
public class PanelChat extends JPanel{
    private int alto;
    private Imagen imagen = new Imagen();
    
    private int cantMensajes = 0;
    private GridBagConstraints gbc;
    
    private JPanel pnlMensajes;
    private JScrollPane scrlMensajes;
    private JScrollBar vertical;
    private JPanel pnlChat;
    private JTextField txtMensaje;
    private JButton btnEnviar;
    
    
    
    Fuentes fuentes = new Fuentes();

    public PanelChat(int alto) {
        this.alto = alto;
        configurar();
    }
     
    private void configurar(){
        setPreferredSize( new Dimension(0,alto));
        setLayout(new BorderLayout());
        
        pnlMensajes = new JPanel();
        pnlMensajes.setLayout(new GridBagLayout());
        
        //Configuración de las restricciones del layout de pnlMensajes
        gbc = new GridBagConstraints();
        gbc.gridx = 0;           // Única columna
        gbc.ipady = 10;
        gbc.weightx = 0.9;      // TRUCO CLAVE 1: Estira el espacio horizontal al máximo
        gbc.fill = GridBagConstraints.HORIZONTAL; // TRUCO CLAVE 2: Obliga al componente a expandirse en su espacio
        gbc.insets = new Insets(0, 0, 8, 0); // Espaciado inferior entre componentes
        
        
        scrlMensajes = new JScrollPane(pnlMensajes);
        scrlMensajes.setPreferredSize( new Dimension(0, (int)(alto*0.875)) );
        scrlMensajes.setBackground(Color.red);
        scrlMensajes.setBorder( BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black) );
        add(scrlMensajes, BorderLayout.NORTH);
        vertical = scrlMensajes.getVerticalScrollBar();
        
        pnlChat = new JPanel(new BorderLayout());
        pnlChat.setPreferredSize( new Dimension(0, (int)(alto*0.125) ) );
        pnlChat.setBackground(Color.WHITE);
        add(pnlChat, BorderLayout.SOUTH);
        
        txtMensaje = new JTextField();
        txtMensaje.setFont(fuentes.fntChat);
       
        pnlChat.add(txtMensaje, BorderLayout.CENTER);
        
        btnEnviar = new JButton(imagen.agregarImagen("/imagen/enviar.png", 50, 50));
        pnlChat.add(btnEnviar, BorderLayout.LINE_END);
        btnEnviar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(txtMensaje.getText());
                agregarMensaje();
                
            }
                }
        );
        
    }
    
    private void agregarMensaje(){
        String msg = txtMensaje.getText();
        //JLabel lbl = new JLabel(msg);
        TarjetaMensaje tMensaje = new TarjetaMensaje(msg, "Yo");
        //lbl.setFont(fuentes.fntBotonesMd);
        gbc.gridy = cantMensajes;
        pnlMensajes.add(tMensaje, gbc);
        pnlMensajes.revalidate();
        pnlMensajes.repaint();
        moverScroll(scrlMensajes);
        
        cantMensajes++;
//        int punto = vertical.getMaximum();
//        vertical.setValue(punto+100);
//        System.out.println(punto);
    }
    
    // Source - https://stackoverflow.com/a/31317110
// Posted by Matthias Braun
// Retrieved 2026-06-24, License - CC BY-SA 3.0

private void moverScroll(JScrollPane scrollPane) {
    JScrollBar barraVertical = scrollPane.getVerticalScrollBar();
    AdjustmentListener scrolleador = new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            Adjustable adjustable = e.getAdjustable();
            adjustable.setValue(adjustable.getMaximum());
            barraVertical.removeAdjustmentListener(this);
        }
    };
    barraVertical.addAdjustmentListener(scrolleador);
}

}
