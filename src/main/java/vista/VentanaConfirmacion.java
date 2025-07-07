package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaConfirmacion extends JFrame {
    private JTextField txtIDAviso = new JTextField(10);
    private JButton btnConfirmar = new JButton("YA TOMÉ MI MEDICINA");

    public VentanaConfirmacion() {
        setTitle("Confirmación de Toma");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblID = new JLabel("ID del Aviso:");
        lblID.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtIDAviso.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));

        btnConfirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnConfirmar.setBackground(new Color(76, 175, 80));
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 14));

        panel.add(lblID);
        panel.add(Box.createVerticalStrut(10));
        panel.add(txtIDAviso);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnConfirmar);

        add(panel);
        setVisible(true);
    }

    public JTextField getTxtIDAviso() {
        return txtIDAviso;
    }

    public JButton getBtnConfirmar() {
        return btnConfirmar;
    }
}
