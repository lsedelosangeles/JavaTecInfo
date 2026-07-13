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
import javax.swing.JDialog;
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

    JDialog dialogoEspera;

    private boolean hayConexion;
    private boolean haySesion;

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
                    
                    mostrarDialogoEspera("Conectando a " + servidor + "..."); //Se cierra con terminarEsperaConectar()
                }
            }
        } else {

            cliente.desconectar();
            mostrarDialogoEspera("Desconectado..."); //Se cierra con terminarEsperaConectar()
            
            
            lblServidor.setText("Desconectado");
            btnConectar.setText("Conectar");
            cliente = null;
        }
        //btnConectar.setEnabled(true);
    }

    /**
     * Muestra el diálogo de espera con un mensaje específico
     * NOTA: Este diálogo bloquea la interfäz y debe cerrarse con un método especial
     * @param mensaje 
     */
    public void mostrarDialogoEspera(String mensaje) {
        JOptionPane panelContenido = new JOptionPane(
                mensaje,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                new Object[]{},
                null
        );

        dialogoEspera = panelContenido.createDialog(this, "");
        dialogoEspera.setModal(true);
        dialogoEspera.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialogoEspera.setVisible(true);
    }

    /**
     * Inicia el proceso de inicio o cierre de sesión
     */
    public void iniciarSesion() {

        //Si no hay sesión, iniciamos
        if (!haySesion) {
            String nombreUsuario = JOptionPane.showInputDialog(
                    this,
                    "Nombre de usuario:",
                    "Inicio de Sesión",
                    JOptionPane.QUESTION_MESSAGE
            );

            // El usuario dio click en "Cancelar"
            if (nombreUsuario == null) {
                return;
            }

            nombreUsuario = nombreUsuario.trim();

            // El nombre de usuario debe tener algún texto. 
            //  La función trim() elimina espacios al comienzo y al final del String
            //  dejando solamente el contenido.
            if (nombreUsuario.isEmpty()) {
                mostrarAviso("El nombre de usuario no puede estar vacío.");
                return;   //El 'return' sin parámetros provoca que se cierre el método y no continúe el proceso.
            }

            // Verificamos que el cliente este conectado antes de enviar la solicitud
            if (cliente == null || !cliente.isConectado()) {
                mostrarAviso("Error: No hay una conexión activa con el servidor.");
                return;
            }

            cliente.login(nombreUsuario);
            
            //Creamos y mostramos un diálogo de espera
            mostrarDialogoEspera("Iniciando sesión...");

            // Si hay sesión, la cerramos
        } else {
            cliente.logout();
            mostrarDialogoEspera("Cerrando la sesión...");
            haySesion = false;
        }

    }

    //Otras funciones
    /**
     * Cierra el diálogo de espera del login con un mensaje
     *
     * @param exito
     * @param mensaje
     */
    public void terminarEsperaLogin(boolean exito, String mensaje) {

        // Si el diálogo existe y está visible, lo cerramos 
        if (dialogoEspera != null && dialogoEspera.isVisible()) {
            dialogoEspera.dispose();
            dialogoEspera = null;
        }

        // Mostramos el aviso
        mostrarAviso(mensaje);

        // Actualizamos el estado de la botonera según el resultado
        if (exito) {
            btnLogin.setEnabled(true);
            btnLogin.setText("Cerrar Sesión");
            haySesion = true;
            btnConectar.setEnabled(false); // Evitamos desconexiones accidentales en partida
        } else {
            //System.out.println("terminando con falso");
            btnLogin.setEnabled(true);
            btnConectar.setEnabled(true);
            btnLogin.setText("Iniciar Sesión");
        }
    }

    /**
     * Cierra el diálogo de espera de la conexión al servidor con un mensaje
     *
     * @param exito
     * @param mensaje
     */
    public void terminarEsperaConectar(boolean exito, String mensaje) {

        // Si el diálogo existe y está visible, lo cerramos 
        if (dialogoEspera != null && dialogoEspera.isVisible()) {
            dialogoEspera.dispose();
            dialogoEspera = null;
        }

        // Mostramos el aviso
        mostrarAviso(mensaje);

        // Actualizamos el estado de la botonera según el resultado
        if (exito) {
            hayConexion = true;
            btnConectar.setText("Desconectar");
            btnConectar.setEnabled(true);
            btnLogin.setEnabled(true);
            btnLogin.setText("Iniciar Sesión");
        } else {
            System.out.println("terminando con falso");
            hayConexion = false;
            btnLogin.setEnabled(false);
            btnConectar.setEnabled(true);
            btnConectar.setText("Conectar");
        }
    }

    /**
     * Muestra un mensaje en un diálogo
     *
     * @param mensaje
     */
    public void mostrarAviso(String mensaje) {
        //JOptionPane.showMessageDialog(this, mensaje);
        SwingUtilities.invokeLater(
                () -> {
                    Dialogo.mostrarAviso(mensaje);
                }
        );

    }

    /**
     * Cambia el estado del botón de inicio de sesión
     *
     * @param habilitado
     */
    public void estadoInicioSesion(boolean habilitado) {
        SwingUtilities.invokeLater(
                () -> {
                    btnLogin.setEnabled(habilitado);
                }
        );

    }
    
    /**
     * Cambia el estado de conectado de la ventana. 
     * NO CONECTA NI DESCONECTA. DEBE LLAMARSE PARA REFLEJAR ESE ESTADO
     * true: el cliente esta conectado a un servidor
     * false:  el cliente no esta conectado a un servidor
     * @param estado 
     */
    public void estadoConectado(boolean estado){
        hayConexion = estado;
        if (estado) {
            btnConectar.setText("Desconectar");
        }
        else{
            btnConectar.setText("Conectar");
            btnLogin.setText("Iniciar Sesión");
            btnLogin.setEnabled(false);
        }
    }

    /**
     * Cambia el nombre mostrado del servidor
     *
     * @param nombre
     */
    public void cambiarNombreServidor(String nombre) {
        SwingUtilities.invokeLater(
                () -> {
                    lblServidor.setText(nombre);
                }
        );

    }

    /**
     * Inicia el cliente
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MiniCliente().setVisible(true);
        });
    }
}
