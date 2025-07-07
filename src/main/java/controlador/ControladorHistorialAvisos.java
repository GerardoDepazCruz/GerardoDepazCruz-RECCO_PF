package controlador;

import vista.VentanaHistorialAvisos;
import modelo.Aviso;
import modelo.AvisoDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorHistorialAvisos {
    private VentanaHistorialAvisos vista;
    private AvisoDAO dao;

    public ControladorHistorialAvisos(VentanaHistorialAvisos vista, AvisoDAO dao) {
        this.vista = vista;
        this.dao = dao;

        cargarTabla();

        this.vista.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarTabla();
            }
        });
    }

    private void cargarTabla() {
        List<Aviso> avisos = dao.obtenerTodosLosAvisos();
        Object[][] datos = new Object[avisos.size()][7];

        for (int i = 0; i < avisos.size(); i++) {
            Aviso a = avisos.get(i);
            datos[i][0] = a.getId();
            datos[i][1] = a.getNombrePaciente();
            datos[i][2] = a.getMedicamento();
            datos[i][3] = a.getContactoFamiliar();
            datos[i][4] = a.isConfirmado() ? "Sí" : "No";
            datos[i][5] = a.isNotificado() ? "Sí" : "No";
            datos[i][6] = a.getFechaHoraRegistro();
        }

        vista.cargarDatos(datos);
    }
}
