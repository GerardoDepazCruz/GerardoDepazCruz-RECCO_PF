package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAO {
    private Connection conexion;

    public AvisoDAO() {
        try {
            // Cambia los datos de tu conexión aquí
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Recordatorios;encrypt=true;trustServerCertificate=true";
            String usuario = "gerardo";
            String contraseña = "123";
            conexion = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            e.printStackTrace();
            conexion = null;
        }
    }

    public List<Aviso> obtenerTodosLosAvisos() {
    List<Aviso> lista = new ArrayList<>();
    String sql = "SELECT * FROM Aviso ORDER BY fechaHoraRegistro DESC";

    try (Statement stmt = conexion.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            Aviso aviso = new Aviso();
            aviso.setId(rs.getInt("id"));
            aviso.setNombrePaciente(rs.getString("nombrePaciente"));
            aviso.setMedicamento(rs.getString("medicamento"));
            aviso.setContactoFamiliar(rs.getString("contactoFamiliar"));
            aviso.setConfirmado(rs.getBoolean("confirmado"));
            aviso.setNotificado(rs.getBoolean("notificado"));
            aviso.setFechaHoraRegistro(rs.getTimestamp("fechaHoraRegistro"));
            lista.add(aviso);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

    
    public boolean confirmarAvisoPorId(int idAviso) {
    String sql = "UPDATE Aviso SET confirmado = 1 WHERE id = ?";
    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setInt(1, idAviso);
        int filas = ps.executeUpdate();
        return filas > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
    public boolean insertarAviso(Aviso aviso) {
        String sql = "INSERT INTO Aviso (nombrePaciente, medicamento, contactoFamiliar, confirmado, notificado, fechaHoraRegistro) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, aviso.getNombrePaciente());
            ps.setString(2, aviso.getMedicamento());
            ps.setString(3, aviso.getContactoFamiliar());
            ps.setBoolean(4, aviso.isConfirmado());
            ps.setBoolean(5, aviso.isNotificado());
            ps.setTimestamp(6, aviso.getFechaHoraRegistro());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Aviso> obtenerAvisosNoConfirmadosNoNotificados() {
        List<Aviso> lista = new ArrayList<>();
        String sql = "SELECT * FROM Aviso WHERE confirmado = 0 AND notificado = 0";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Aviso aviso = new Aviso();
                aviso.setId(rs.getInt("id"));
                aviso.setNombrePaciente(rs.getString("nombrePaciente"));
                aviso.setMedicamento(rs.getString("medicamento"));
                aviso.setContactoFamiliar(rs.getString("contactoFamiliar"));
                aviso.setConfirmado(rs.getBoolean("confirmado"));
                aviso.setNotificado(rs.getBoolean("notificado"));
                aviso.setFechaHoraRegistro(rs.getTimestamp("fechaHoraRegistro"));
                lista.add(aviso);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void marcarComoNotificado(int id) {
        String sql = "UPDATE Aviso SET notificado = 1 WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
