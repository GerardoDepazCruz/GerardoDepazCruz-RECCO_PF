/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejecutor;

import vista.VentanaConfirmacion;
import modelo.AvisoDAO;
import controlador.ControladorConfirmacion;

public class EjecutableConfirmacion {
    public static void main(String[] args) {
        VentanaConfirmacion vista = new VentanaConfirmacion();
        AvisoDAO dao = new AvisoDAO();
        new ControladorConfirmacion(vista, dao);
    }
}

