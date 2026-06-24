/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import com.ejemplo.juegopet2026.herramientas.Imagen;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author sebastian
 */
public class PanelChat extends JPanel{
    private int alto;
    private Imagen imagen = new Imagen();
    
    private JPanel pnlMensajes;
    private JScrollPane scrlMensajes;
    private JPanel pnlChat;
    private JTextField txtMensaje;
    private JButton btnEnviar;

    public PanelChat(int alto) {
        this.alto = alto;
        configurar();
    }
     
    private void configurar(){
        setPreferredSize( new Dimension(0,alto));
        setLayout(new BorderLayout());
        
        pnlChat = new JPanel();
    }
}
