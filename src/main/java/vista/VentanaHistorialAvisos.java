package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaHistorialAvisos extends JFrame {
    private JTable tablaAvisos;
    private JButton btnActualizar;

    public VentanaHistorialAvisos() {
        setTitle("Historial de Avisos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Tabla
        tablaAvisos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaAvisos);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botón actualizar
        btnActualizar = new JButton("Actualizar Historial");
        btnActualizar.setBackground(new Color(33, 150, 243));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(btnActualizar, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public JTable getTablaAvisos() {
        return tablaAvisos;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void cargarDatos(Object[][] datos) {
        String[] columnas = {"ID", "Paciente", "Medicamento", "Contacto", "Confirmado", "Notificado", "Fecha"};
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tablaAvisos.setModel(modelo);
    }
}
