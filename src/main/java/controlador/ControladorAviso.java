/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Aviso;
import modelo.AvisoDAO;
import vista.VentanaAviso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorAviso {
    private VentanaAviso vista;
    private AvisoDAO dao;

    public ControladorAviso(VentanaAviso vista, AvisoDAO dao) {
        this.vista = vista;
        this.dao = dao;

        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarAviso();
            }
        });
    }

    private void registrarAviso() {
        String nombre = vista.txtNombre.getText().trim();
        String medicamento = vista.txtMedicamento.getText().trim();
        String contacto = vista.txtContacto.getText().trim();

        if (nombre.isEmpty() || medicamento.isEmpty() || contacto.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Completa todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Aviso aviso = new Aviso();
        aviso.setNombrePaciente(nombre);
        aviso.setMedicamento(medicamento);
        aviso.setContactoFamiliar(contacto);
        aviso.setConfirmado(false);
        aviso.setNotificado(false);
        aviso.setFechaHoraRegistro(Timestamp.valueOf(LocalDateTime.now()));

        if (dao.insertarAviso(aviso)) {
            JOptionPane.showMessageDialog(vista, "Aviso registrado correctamente");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al registrar el aviso");
        }
    }

    private void limpiarCampos() {
        vista.txtNombre.setText("");
        vista.txtMedicamento.setText("");
        vista.txtContacto.setText("");
    }

    // Se llama cada minuto desde el ejecutor
    public void verificarAvisos() {
        List<Aviso> avisosPendientes = dao.obtenerAvisosNoConfirmadosNoNotificados();

        for (Aviso aviso : avisosPendientes) {
            LocalDateTime fechaRegistro = aviso.getFechaHoraRegistro().toLocalDateTime();
            long minutosTranscurridos = ChronoUnit.MINUTES.between(fechaRegistro, LocalDateTime.now());

            if (minutosTranscurridos >= 30) {
                // Simulación de notificación por WhatsApp
                System.out.println("🔔 Aviso automático enviado a " + aviso.getContactoFamiliar()
                        + ": El paciente " + aviso.getNombrePaciente() + " no tomó el medicamento '" + aviso.getMedicamento() + "'.");

                dao.marcarComoNotificado(aviso.getId());
            }
        }
    }
}



