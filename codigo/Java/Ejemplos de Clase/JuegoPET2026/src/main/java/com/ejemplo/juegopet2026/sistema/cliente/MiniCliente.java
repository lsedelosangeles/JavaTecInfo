/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.cliente;

import com.ejemplo.juegopet2026.interfaz.Dialogo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author sebastian
 */
public class MiniCliente extends JFrame {

    private Cliente cliente;

    private JPanel pnlChat;
    private JPanel pnlUsuario;

    //Panel Usuario
    private JLabel lblServidor;
    private JPanel pnlBotonera;
    private JList<String> lstUsuarios;
    private JScrollPane scrlConectados;
    private JButton btnConectar;
    private JButton btnLogin;

    GridBagConstraints gbc = new GridBagConstraints();

    private DefaultListModel<String> listaDeUsuarios;

    public MiniCliente() {

        configurar();
        configurarBotones();
    }

    private void configurar() {
        setSize(800, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pnlChat = new JPanel(new BorderLayout());
        pnlChat.setPreferredSize(new Dimension(550, 0));
        pnlChat.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.black));
        add(pnlChat, BorderLayout.EAST);

        pnlUsuario = new JPanel(new BorderLayout());
        pnlUsuario.setPreferredSize(new Dimension(250, 0));
        add(pnlUsuario, BorderLayout.WEST);

        //Panel Usuario
        // 
        lblServidor = new JLabel("Desconectado");
        pnlUsuario.add(lblServidor, BorderLayout.NORTH);
        // Botonera
        pnlBotonera = new JPanel(new GridBagLayout());
        pnlBotonera.setPreferredSize(new Dimension(0, 100));
        pnlBotonera.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
        pnlUsuario.add(pnlBotonera, BorderLayout.SOUTH);

        btnConectar = new JButton("Conectarse");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 15, 5, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlBotonera.add(btnConectar, gbc);

        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setEnabled(false);
        gbc.gridy = 1;
        pnlBotonera.add(btnLogin, gbc);

        // Listado de Usuarios
        listaDeUsuarios = new DefaultListModel<>();
        listaDeUsuarios.addElement("No hay usuarios conectados");

        lstUsuarios = new JList<>(listaDeUsuarios);
        scrlConectados = new JScrollPane(lstUsuarios);
        scrlConectados.setBackground(Color.red);
        scrlConectados.setPreferredSize(new Dimension(0, 500));
        pnlUsuario.add(scrlConectados, BorderLayout.CENTER);

        // 
    }

    private void configurarBotones() {
        btnConectar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conectar();
            }
        });

        btnLogin.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        }
        );

    }

    //Acciones de los botones
    /**
     * Inicia el proceso de conectar el cliente al servidor
     */
    private void conectar() {
        btnConectar.setEnabled(false);

        if (cliente == null || !cliente.isConectado()) {
            btnConectar.setText("Conectando...");

            String servidor = JOptionPane.showInputDialog("Ingrese la IP del Servidor:", "localhost");
            if (servidor != null) {
                int puerto = 0;
                String puerto_ = JOptionPane.showInputDialog("Ingrese el puerto del servidor", "6666");
                if (puerto_ != null) {
                    puerto = Integer.parseInt(puerto_);
                    cliente = new Cliente(servidor, puerto, this);
                    cliente.iniciarConexion();
                    btnConectar.setText("Desconectar");
                }
            }
        } else {

            btnConectar.setText("Desconectando...");
            cliente.desconectar();
            lblServidor.setText("Desconectado");
            btnConectar.setText("Conectar");
            cliente = null;
        }
        btnConectar.setEnabled(true);
    }

    public void iniciarSesion() {

    }

    //Otras funciones
    public void mostrarAviso(String mensaje) {
        //JOptionPane.showMessageDialog(this, mensaje);
        Dialogo.mostrarAviso(mensaje);
    }

    public void estadoInicioSesion(boolean habilitado) {
        btnLogin.setEnabled(habilitado);
    }

    public void cambiarNombreServidor(String nombre) {
        lblServidor.setText(nombre);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MiniCliente().setVisible(true);
            //new Inicio().setVisible(true);
        });
    }
}
