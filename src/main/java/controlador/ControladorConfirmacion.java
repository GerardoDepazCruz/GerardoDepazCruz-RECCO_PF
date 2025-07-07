package controlador;

import vista.VentanaConfirmacion;
import modelo.AvisoDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorConfirmacion {
    private VentanaConfirmacion vista;
    private AvisoDAO dao;

    public ControladorConfirmacion(VentanaConfirmacion vista, AvisoDAO dao) {
        this.vista = vista;
        this.dao = dao;

        this.vista.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idAviso = Integer.parseInt(vista.getTxtIDAviso().getText().trim());
                boolean exito = dao.confirmarAvisoPorId(idAviso);
                if (exito) {
                    JOptionPane.showMessageDialog(vista, "¡MUY BIEN! Has confirmado tu medicamento.");
                } else {
                    JOptionPane.showMessageDialog(vista, "Error: No se pudo confirmar.");
                }
            }
        });
    }
}
