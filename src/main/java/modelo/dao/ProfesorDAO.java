package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.ProfesorDTO; // Asegúrate de tener este DTO en el paquete correcto
import conexion.ConexionBD;
import conexion.ConsultaProfesor;

public class ProfesorDAO {
    private ConexionBD conexionBD;

    public ProfesorDAO() {
        this.conexionBD = new ConexionBD();  // Asegúrate de que esto no sea null
    }

    // Insertar un nuevo profesor
    public void insertarProfesor(int id, String nombre, int edad, String facultad, String asignatura) throws SQLException {
        try (Connection con = conexionBD.getConnecion(); 
             PreparedStatement preparedStatement = con.prepareStatement(ConsultaProfesor.insertarProfesores())) {

            // Establecer los valores del PreparedStatement
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nombre);
            preparedStatement.setInt(3, edad);
            preparedStatement.setString(4, facultad);
            preparedStatement.setString(5, asignatura);

            // Ejecutar la actualización
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Registro Exitoso");
            } else {
                System.out.println("Registro Fallido");
            }
        }
    }

    // Obtener todos los profesores
    public List<ProfesorDTO> obtenerProfesores() throws SQLException {
        List<ProfesorDTO> listaProfesores = new ArrayList<>();

        String sql = "SELECT * FROM Profesores";
        try (Connection con = conexionBD.getConnecion();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                ProfesorDTO profesor = new ProfesorDTO();
                profesor.setId(resultSet.getInt("id"));
                profesor.setNombre(resultSet.getString("nombre"));
                profesor.setEdad(resultSet.getInt("edad"));
                profesor.setFacultad(resultSet.getString("facultad"));
                profesor.setAsignatura(resultSet.getString("asignatura"));

                listaProfesores.add(profesor);
            }
        }
        return listaProfesores;
    }

    // Obtener un profesor por ID
    public ProfesorDTO obtenerProfesorPorId(int id) throws SQLException {
        ProfesorDTO profesor = null;
        try (Connection connection = conexionBD.getConnecion();
             PreparedStatement preparedStatement = connection.prepareStatement(ConsultaProfesor.obtenerProfesorPorId())) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    profesor = new ProfesorDTO();
                    profesor.setId(resultSet.getInt("id"));
                    profesor.setNombre(resultSet.getString("nombre"));
                    profesor.setEdad(resultSet.getInt("edad"));
                    profesor.setFacultad(resultSet.getString("facultad"));
                    profesor.setAsignatura(resultSet.getString("asignatura"));
                }
            }
        }
        return profesor;
    }

    // Actualizar un profesor
    public void actualizarProfesor(int id, String nombre, int edad, String facultad, String asignatura) throws SQLException {
        try (Connection connection = conexionBD.getConnecion();
             PreparedStatement preparedStatement = connection.prepareStatement(ConsultaProfesor.actualizarProfesores())) {

            // Establecer los valores del PreparedStatement
            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, edad);
            preparedStatement.setString(3, facultad);
            preparedStatement.setString(4, asignatura);
            preparedStatement.setInt(5, id);

            // Ejecutar la actualización
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Registro actualizado exitosamente.");
            } else {
                System.out.println("Actualización fallida.");
            }
        }
    }

    // Eliminar un profesor por ID
    public void borrarProfesor(int id) throws SQLException {
        try (Connection connection = conexionBD.getConnecion();
             Statement statement = connection.createStatement()) {
            int rows = statement.executeUpdate(ConsultaProfesor.borrarProfesoresid(id));
            if (rows > 0) {
                System.out.println("Registro eliminado exitosamente.");
            } else {
                System.out.println("Algo salió mal.");
            }
        }
    }
}
