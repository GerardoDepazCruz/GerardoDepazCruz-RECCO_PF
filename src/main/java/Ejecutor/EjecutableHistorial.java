package Ejecutor;

import vista.VentanaHistorialAvisos;
import modelo.AvisoDAO;
import controlador.ControladorHistorialAvisos;

public class EjecutableHistorial {
    public static void main(String[] args) {
        VentanaHistorialAvisos vista = new VentanaHistorialAvisos();
        AvisoDAO dao = new AvisoDAO();
        new ControladorHistorialAvisos(vista, dao);
    }
}
