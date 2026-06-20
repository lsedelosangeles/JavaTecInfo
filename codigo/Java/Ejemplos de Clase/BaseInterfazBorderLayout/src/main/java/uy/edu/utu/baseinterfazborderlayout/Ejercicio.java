/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.utu.baseinterfazborderlayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author sebastian
 */
public class Ejercicio extends JFrame {

    private Dimension resolucion = Toolkit.getDefaultToolkit().getScreenSize();
    private int alto = (int) (resolucion.height * 0.75);
    private int ancho = (int) (resolucion.width * 0.75);

    private JPanel latDerecho;
    private JPanel latDerechoJuego;
    private JPanel latIzquierdo;
    private JPanel latInferiorDer;
    private JPanel latInferiorDerLabels;
    private JPanel latInferiorDerBotonera;
    private JPanel latIzquierdoChat;
    private JPanel latIzquierdoChatLista;
    private JPanel latIzquierdoChatMensaje;
    private JPanel latIzquierdoBotonera;
    private JButton btnMenu;
    private JButton btnPersonaje;
    private JButton btnItems;
    private JButton btnUsuario;
    private JButton btnEnviarMensaje;
    private JTextField txtfMensaje;
    private JButton btnAtaque;
    private JButton btnDefensa;
    private JButton btnEquipo;
    private JLabel lblNombre;
    private JLabel lblHP;
    private JLabel lblMP;

    public Ejercicio() {
        configurar();
    }

    private void configurar() {
        setSize(ancho, alto);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BorderLayout gestor = new BorderLayout();
        getContentPane().setLayout(gestor);

        latDerecho = new JPanel(new BorderLayout());
        Dimension dimLatDerecho = new Dimension((int) (ancho * 0.8), 0);
        latDerecho.setPreferredSize(dimLatDerecho);
        //latDerecho.setBackground(Color.red);
        getContentPane().add(latDerecho, BorderLayout.LINE_END);

        latDerechoJuego = new JPanel(new BorderLayout());
        latDerechoJuego.setBackground(Color.WHITE);
        latDerechoJuego.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        latDerecho.add(latDerechoJuego, BorderLayout.CENTER);

        latIzquierdo = new JPanel(new BorderLayout());
        latIzquierdo.setPreferredSize(new Dimension((int) (ancho * 0.2), 0));
        latIzquierdo.setBackground(Color.WHITE);
        getContentPane().add(latIzquierdo, BorderLayout.WEST);

        latIzquierdoBotonera = new JPanel(new GridLayout(4, 1));
        latIzquierdoBotonera.setPreferredSize(new Dimension(0, (int) (alto * 0.3)));
        latIzquierdoBotonera.setBackground(Color.white);
        latIzquierdo.add(latIzquierdoBotonera, BorderLayout.PAGE_END);

        btnMenu = new JButton("Menú");
        btnPersonaje = new JButton("Personaje");
        btnItems = new JButton("Items");
        btnUsuario = new JButton("Usuario");
        latIzquierdoBotonera.add(btnMenu);
        latIzquierdoBotonera.add(btnPersonaje);
        latIzquierdoBotonera.add(btnItems);
        latIzquierdoBotonera.add(btnUsuario);

        latIzquierdoChat = new JPanel(new BorderLayout());
        latIzquierdoChat.setPreferredSize(new Dimension(0, (int) (alto * 0.66)));
        //latIzquierdoChat.setBackground(Color.ORANGE);
        //latIzquierdoChat.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        latIzquierdo.add(latIzquierdoChat, BorderLayout.PAGE_START);

        latIzquierdoChatLista = new JPanel();
        latIzquierdoChatLista.setBackground(Color.white);
        latIzquierdoChatLista.setPreferredSize(new Dimension(0, (int) (alto * 0.59))); //(int)(latIzquierdoChat.getHeight()*0.9)));
        latIzquierdoChat.add(latIzquierdoChatLista, BorderLayout.PAGE_START);

        latIzquierdoChatMensaje = new JPanel(new BorderLayout(10, 10));
        latIzquierdoChatMensaje.setPreferredSize(new Dimension(0, (int) (alto * 0.07)));
        latIzquierdoChatMensaje.setBackground(Color.WHITE);
        latIzquierdoChatMensaje.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        latIzquierdoChat.add(latIzquierdoChatMensaje, BorderLayout.PAGE_END);

        txtfMensaje = new JTextField();
        //txtfMensaje.setPreferredSize( new Dimension((int)(ancho*0.),20));
        txtfMensaje.setFont(new Font("Helvetica", Font.PLAIN, 24));
        latIzquierdoChatMensaje.add(txtfMensaje, BorderLayout.CENTER);

        btnEnviarMensaje = new JButton();
        //btnEnviarMensaje.setBackground(Color.darkGray);
        btnEnviarMensaje.setIcon(agregarImagen("/imagen/send.png", 50, 50));
        latIzquierdoChatMensaje.add(btnEnviarMensaje, BorderLayout.LINE_END);

        latInferiorDer = new JPanel(new BorderLayout());
        Dimension dimInferiorIzq = new Dimension(0, 100);
        latInferiorDer.setPreferredSize(dimInferiorIzq);
        //latInferiorDer.setBackground(Color.BLUE);
        latDerecho.add(latInferiorDer, BorderLayout.SOUTH);

        latInferiorDerLabels = new JPanel(new GridLayout(1, 3));
        latInferiorDerLabels.setPreferredSize(new Dimension((int) (ancho * 0.5), 0));
        //latInferiorDerLabels.setBackground(Color.PINK);
        latInferiorDer.add(latInferiorDerLabels, BorderLayout.LINE_START);

        lblNombre = new JLabel("  Nombre");
        lblNombre.setFont(new Font("Helvetica", Font.BOLD, 28));
        latInferiorDerLabels.add(lblNombre);

        lblHP = new JLabel("<html><b>HP:</b>100/100</html>");
        lblHP.setFont(new Font("Helvetica", Font.PLAIN, 30));
        latInferiorDerLabels.add(lblHP);

        lblMP = new JLabel("<html><b>MP:</b>100/100</html>");
        lblMP.setFont(new Font("Helvetica", Font.PLAIN, 30));
        latInferiorDerLabels.add(lblMP);

        latInferiorDerBotonera = new JPanel(new GridLayout(1, 3, 5, 0));
        latInferiorDerBotonera.setPreferredSize(new Dimension((int) (ancho * 0.3), 0));
        //latInferiorDerBotonera.setBackground(Color.pink);
        latInferiorDer.add(latInferiorDerBotonera, BorderLayout.LINE_END);

        btnAtaque = new JButton(agregarImagen("/imagen/sword.png", 80, 80));
        latInferiorDerBotonera.add(btnAtaque);

        btnDefensa = new JButton(agregarImagen("/imagen/shield.png", 80, 80));
        latInferiorDerBotonera.add(btnDefensa);

        btnEquipo = new JButton(agregarImagen("/imagen/potion.png", 80, 80));
        latInferiorDerBotonera.add(btnEquipo);

        setMaximumSize(new Dimension(ancho, alto));
        setResizable(false);
        getContentPane().validate();
        getContentPane().repaint();
    }

    /**
     * Permite obtener un recurso de imagen para cargar en un componente.
     *
     * @param rutaImagen
     * @param ancho
     * @param alto
     * @return
     */
    private ImageIcon agregarImagen(String rutaImagen, int ancho, int alto) {
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

    public static void main(String[] args) {
        new Ejercicio();
    }

}
