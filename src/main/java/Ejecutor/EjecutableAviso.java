/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejecutor;

import controlador.ControladorAviso;
import modelo.AvisoDAO;
import vista.VentanaAviso;

import java.util.Timer;
import java.util.TimerTask;

public class EjecutableAviso {
    public static void main(String[] args) {
        // Crear vista
        VentanaAviso vista = new VentanaAviso();

        // Crear DAO (el constructor ya abre la conexión interna)
        AvisoDAO dao = new AvisoDAO();

        // Crear controlador
        ControladorAviso controlador = new ControladorAviso(vista, dao);

        // Mostrar ventana
        vista.setVisible(true);

        // Temporizador para verificación automática cada 60 segundos
        Timer temporizador = new Timer();
        temporizador.schedule(new TimerTask() {
            @Override
            public void run() {
                controlador.verificarAvisos();
            }
        }, 0, 60000); // 1 minuto (60000 ms)
    }
}

