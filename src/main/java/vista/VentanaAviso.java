package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaAviso extends JFrame {

    public JTextField txtNombre = new JTextField(15);
    public JTextField txtMedicamento = new JTextField(15);
    public JTextField txtContacto = new JTextField(15);
    public JButton btnRegistrar = new JButton("Registrar Aviso");
    private JLabel lblImagen;

    public VentanaAviso() {
        // Configurar ventana estilo móvil
        setTitle("Aviso a Familiar");
        setSize(400, 650); // Tamaño tipo celular
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(Color.WHITE);

        Font fontLabel = new Font("Segoe UI", Font.PLAIN, 14);
        Font fontField = new Font("Segoe UI", Font.PLAIN, 14);

        // Panel contenedor del título con centrado
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelTitulo.setBackground(Color.WHITE); // Mismo fondo que el principal

// Título del formulario
        JLabel lblTitulo = new JLabel("Gestión de Notificación");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(33, 150, 243));

        panelTitulo.add(lblTitulo);
        panelPrincipal.add(panelTitulo); // Agregar el panel con el título centrado
        panelPrincipal.add(Box.createVerticalStrut(20)); // Espacio debajo del título

        // Campo: Nombre del paciente
        JLabel lblNombre = new JLabel("Nombre del paciente:");
        lblNombre.setFont(fontLabel);
        lblNombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelPrincipal.add(lblNombre);

        txtNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        txtNombre.setFont(fontField);
        panelPrincipal.add(txtNombre);
        panelPrincipal.add(Box.createVerticalStrut(15));

        // Campo: Medicamento
        JLabel lblMedicamento = new JLabel("Medicamento:");
        lblMedicamento.setFont(fontLabel);
        lblMedicamento.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelPrincipal.add(lblMedicamento);

        txtMedicamento.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        txtMedicamento.setFont(fontField);
        panelPrincipal.add(txtMedicamento);
        panelPrincipal.add(Box.createVerticalStrut(15));

        // Campo: Contacto familiar
        JLabel lblContacto = new JLabel("Contacto del familiar (WhatsApp):");
        lblContacto.setFont(fontLabel);
        lblContacto.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelPrincipal.add(lblContacto);

        txtContacto.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        txtContacto.setFont(fontField);
        panelPrincipal.add(txtContacto);
        panelPrincipal.add(Box.createVerticalStrut(20));

        // Botón registrar
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistrar.setPreferredSize(new Dimension(200, 40));
        btnRegistrar.setBackground(new Color(33, 150, 243));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        panelPrincipal.add(btnRegistrar);
        panelPrincipal.add(Box.createVerticalStrut(25));

        // Imagen inferior centrada
        lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblImagen.setPreferredSize(new Dimension(200, 250));

        // Cargar imagen desde recurso local (ajusta la ruta)
        ImageIcon icono = new ImageIcon("C:\\Users\\Gerardo\\Downloads\\noti.png");
        Image imagenEscalada = icono.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        lblImagen.setIcon(new ImageIcon(imagenEscalada));

        panelPrincipal.add(lblImagen);

        add(panelPrincipal);
        setVisible(true);
    }
}
