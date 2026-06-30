import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoUsuario extends JDialog {

    private JTextField txtNombre;
    private JButton btnRegistrar;
    private JButton btnCancelar;

    public DialogoUsuario(Frame padre) {
        // 'true' hace que el diálogo sea modal (bloquea la ventana principal hasta
        // cerrarse)
        super(padre, "Registro", true);

        // 1. Configuración del Layout Principal del JDialog
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Configuración por defecto para el espaciado (Margen general)
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 2. TÍTULO: "Nuevo Usuario"
        JLabel lblTitulo = new JLabel("Nuevo Usuario", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa las dos columnas
        add(lblTitulo, gbc);

        // 3. ETIQUETA: "Nombre:"
        JLabel lblNombre = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Regresa a ocupar una sola columna
        add(lblNombre, gbc);

        // 4. CAMPO DE TEXTO
        txtNombre = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtNombre, gbc);

        // 5. PANEL DE BOTONES (Contenedor secundario para <Registrar> <Cancelar>)
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnCancelar);

        // Añadir el panel de botones al JDialog
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupa ambas columnas para centrarse abajo
        gbc.insets = new Insets(15, 15, 10, 15); // Un poco más de espacio superior
        add(panelBotones, gbc);

        // 6. Acciones de los botones
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el diálogo
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                if (!nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(DialogoUsuario.this, "Usuario " + nombre + " registrado.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(DialogoUsuario.this, "Por favor, ingresa un nombre.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 7. Ajustes finales de la ventana
        pack(); // Adapta el tamaño del diálogo al contenido exacto
        setLocationRelativeTo(padre); // Centra el diálogo respecto a la ventana principal
        setResizable(false); // Evita que el usuario lo deforme
    }

    // Método Main para probar el JDialog de manera independiente
    public static void main(String[] args) {
        // Creamos una ventana padre simulada
        JFrame framePrincipal = new JFrame();
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(400, 300);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setVisible(true);

        // Lanzamos el diálogo apuntando al frame principal
        DialogoUsuario dialogo = new DialogoUsuario(framePrincipal);
        dialogo.setVisible(true);
    }
}