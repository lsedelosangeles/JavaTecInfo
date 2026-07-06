/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.interfaz.servidor;

import com.ejemplo.juegopet2026.Fuentes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * Ventana para monitorear y controlar el estado del servidor
 *
 * @author sebastian
 */
public class Inicio extends JFrame {

    private JTextArea areaTerminal;
    private JScrollPane scrlTerminal;
    private JList<String> lstUsuarios;
    private JScrollPane scrlUsuarios;
    private JPanel pnlEstado;
    private JPanel pnlCentral;
    private JPanel pnlBotones;
    private JButton btnIniciar;
    private JButton btnDetener;
    private JLabel estadoLabel;

    private DefaultListModel<String> listaDeUsuarios;

    private Fuentes fuentes = new Fuentes();

    public Inicio() {
        configurar();
        registrarMensaje("Listo");
    }

    private void configurar() {
        setTitle("Panel de Control del Servidor");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        listaDeUsuarios = new DefaultListModel<>();
        listaDeUsuarios.addElement("No hay usuarios conectados");

        // Configuramos el área de texto de la terminal
        pnlCentral = new JPanel(new BorderLayout());
        pnlCentral.setBackground(Color.red);
        add(pnlCentral, BorderLayout.CENTER);

        areaTerminal = new JTextArea();
        areaTerminal.setEditable(false);

        areaTerminal.setBackground(Color.BLACK.BLACK);
        areaTerminal.setForeground(Color.GREEN);
        areaTerminal.setFont(fuentes.fntTerminalServidor);

        scrlTerminal = new JScrollPane(areaTerminal);
        scrlTerminal.setPreferredSize(new Dimension(550, 0));
        pnlCentral.add(scrlTerminal, BorderLayout.EAST);

        lstUsuarios = new JList<>(listaDeUsuarios);
        scrlUsuarios = new JScrollPane(lstUsuarios);
        scrlUsuarios.setPreferredSize(new Dimension(250, 0));
        pnlCentral.add(scrlUsuarios, BorderLayout.WEST);

        //Panel Superior para mostrar el estado del servidor
        pnlEstado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        estadoLabel = new JLabel("Estado: APAGADO");
        estadoLabel.setFont(fuentes.fntBotonesMd);
        estadoLabel.setForeground(Color.RED);
        pnlEstado.add(estadoLabel);
        add(pnlEstado, BorderLayout.NORTH);

        pnlBotones = new JPanel();
        btnIniciar = new JButton("Iniciar Servidor");
        btnIniciar.setFont(fuentes.fntBotonesCh);
        btnIniciar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarServidor();
            }
        });

        btnDetener = new JButton("Detener Servidor");
        btnDetener.setEnabled(false);  //NOTA: El boton 'Detener Servidor se inicia deshabilitado ya que no tiene uso si el servidor no esta iniciado'
        btnDetener.setFont(fuentes.fntBotonesCh);
        btnDetener.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detenerServidor();
            }
        }
        );

        pnlBotones.add(btnIniciar);
        pnlBotones.add(btnDetener);
        add(pnlBotones, BorderLayout.SOUTH);

    }

    private void configurarBotones() {

    }

    /**
     * Permite iniciar el servidor
     */
    private void iniciarServidor() {
        registrarMensaje("Iniciando el servidor...");


        estadoLabel.setText("Estado: EN LÍNEA");
        estadoLabel.setForeground(Color.BLUE);
        btnIniciar.setEnabled(false);
        btnDetener.setEnabled(true);
    }

    private void detenerServidor() {

        estadoLabel.setText("Estado: APAGADO");
        estadoLabel.setForeground(Color.RED);
        btnIniciar.setEnabled(true);
        btnDetener.setEnabled(false);
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
                LocalDateTime ahora = LocalDateTime.now();
                DateTimeFormatter formatoTiempo = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String marcaDeTiempo = ahora.format(formatoTiempo);
                areaTerminal.append(marcaDeTiempo + ": " + mensaje + "\n");

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
