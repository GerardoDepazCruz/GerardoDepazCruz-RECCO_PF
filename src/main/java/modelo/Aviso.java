package modelo;

import java.sql.Timestamp;

public class Aviso {
    private int id;
    private String nombrePaciente;
    private String medicamento;
    private String contactoFamiliar;
    private boolean confirmado;
    private boolean notificado;
    private Timestamp fechaHoraRegistro;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getContactoFamiliar() {
        return contactoFamiliar;
    }

    public void setContactoFamiliar(String contactoFamiliar) {
        this.contactoFamiliar = contactoFamiliar;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public boolean isNotificado() {
        return notificado;
    }

    public void setNotificado(boolean notificado) {
        this.notificado = notificado;
    }

    public Timestamp getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Timestamp fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }
}
