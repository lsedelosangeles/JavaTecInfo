/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.interfaz.servidor;

import com.ejemplo.juegopet2026.Fuentes;
import com.ejemplo.juegopet2026.sistema.Servidor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author sebastian
 */
public class Inicio extends JFrame {

    private JTextArea areaTerminal;
    private JScrollPane scrlTerminal;
    private JPanel pnlEstado;
    private JPanel pnlBotones;
    private JButton btnIniciar;
    private JButton btnDetener;
    private JLabel estadoLabel;

    private Servidor servidor;

    private Fuentes fuentes = new Fuentes();

    public Inicio() {
        configurar();
    }

    private void configurar() {
        setTitle("Panel de Control del Servidor");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Configuramos el área de texto
        areaTerminal = new JTextArea();
        areaTerminal.setEditable(false);

        areaTerminal.setBackground(Color.BLACK.BLACK);
        areaTerminal.setForeground(Color.GREEN);
        areaTerminal.setFont(fuentes.fntTerminalServidor);

        scrlTerminal = new JScrollPane(areaTerminal);
        add(scrlTerminal, BorderLayout.CENTER);

        //Panel Superior para mostrar el estado del servidor
        pnlEstado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        estadoLabel = new JLabel("Estado: APAGADO");
        estadoLabel.setForeground(Color.RED);
        pnlEstado.add(estadoLabel);
        add(pnlEstado, BorderLayout.NORTH);

        pnlBotones = new JPanel();
        btnIniciar = new JButton("Iniciar Servidor");
        btnIniciar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarServidor();
            }
        });

        btnDetener = new JButton("Detener Servidor");
        btnDetener.setEnabled(false);  //NOTA: El boton 'Detener Servidor se inicia deshabilitado ya que no tiene uso si el servidor no esta iniciado'
        btnDetener.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        );

        pnlBotones.add(btnIniciar);
        pnlBotones.add(btnDetener);
        add(pnlBotones, BorderLayout.SOUTH);

    }

    /**
     * Permite iniciar el servidor
     */
    private void iniciarServidor() {
        //registrarMensaje("Iniciando el servidor en el puerto 6666...");
        // Aquí instancian e inician el hilo de su servidor
        servidor = new Servidor(6666, Inicio.this);
        new Thread(servidor).start();

        estadoLabel.setText("Estado: EN LÍNEA");
        estadoLabel.setForeground(Color.BLUE);
        btnIniciar.setEnabled(false);
        btnDetener.setEnabled(true);
    }
    
    
    private void detenerServidor(){
        //resgistrar
    }

    /**
     * Permite agregar, de forma segura, los mensajes del servidor al área de
     * texto
     *
     * @param mensaje
     */
    public void registrarMensaje(String mensaje) {
        // SwingUtilities asegura que el texto se agregue en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                areaTerminal.append(mensaje + "\n");

                // Mueve el scroll baje automáticamente al texto nuevo que agregamos
                areaTerminal.setCaretPosition(areaTerminal.getDocument().getLength());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }
}
