package modelo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.ProfesorDTO;
import modelo.entiedades.Profesor;
import conexion.ConexionBD;
import conexion.ConsultaProfesor;
import modelo.entiedades.MapHandler;

public class ProfesorDAO implements interfaceDao<ProfesorDTO> {
    private ConexionBD conexionBD;

    public ProfesorDAO() {
        this.conexionBD = new ConexionBD();
    }

    @Override
    public void crear(ProfesorDTO entidad) throws SQLException {
        // Convertir el DTO a la entidad Profesor usando el MapHandler
        Profesor profesor = MapHandler.dtoToProfesor(entidad);
        
        try (Connection con = conexionBD.getConnecion(); 
             PreparedStatement preparedStatement = con.prepareStatement(ConsultaProfesor.insertarProfesores())) {

            // Usar el objeto Profesor para asignar valores al PreparedStatement
            preparedStatement.setInt(1, profesor.getId());
            preparedStatement.setString(2, profesor.getNombre());
            preparedStatement.setInt(3, profesor.getEdad());
            preparedStatement.setString(4, profesor.getFacultad());
            preparedStatement.setString(5, profesor.getAsignatura());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Registro Exitoso");
            } else {
                System.out.println("Registro Fallido: no se insertó ningún registro.");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            throw e; // re-lanzar para manejar en el servlet
        }
    }

    @Override
    public ProfesorDTO leer(int id) throws SQLException {
        ProfesorDTO profesorDTO = null;
        try (Connection connection = conexionBD.getConnecion();
             PreparedStatement preparedStatement = connection.prepareStatement(ConsultaProfesor.obtenerProfesorPorId())) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Profesor profesor = new Profesor();
                    profesor.setId(resultSet.getInt("id"));
                    profesor.setNombre(resultSet.getString("nombre"));
                    profesor.setEdad(resultSet.getInt("edad"));
                    profesor.setFacultad(resultSet.getString("facultad"));
                    profesor.setAsignatura(resultSet.getString("asignatura"));

                    // Convertir la entidad Profesor a DTO usando el MapHandler
                    profesorDTO = MapHandler.profesorToDto(profesor);
                }
            }
        }
        return profesorDTO;
    }

    @Override
    public void actualizar(ProfesorDTO entidad) throws SQLException {
        Profesor profesor = MapHandler.dtoToProfesor(entidad); // Convertir DTO a entidad
        try (Connection connection = conexionBD.getConnecion();
             PreparedStatement preparedStatement = connection.prepareStatement(ConsultaProfesor.actualizarProfesores())) {

            preparedStatement.setString(1, profesor.getNombre());
            preparedStatement.setInt(2, profesor.getEdad());
            preparedStatement.setString(3, profesor.getFacultad());
            preparedStatement.setString(4, profesor.getAsignatura());
            preparedStatement.setInt(5, profesor.getId());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Registro actualizado exitosamente.");
            } else {
                System.out.println("Actualización fallida.");
            }
        }
    }

    @Override
    public void eliminar(int id) throws SQLException {
        try (Connection connection = conexionBD.getConnecion();
             PreparedStatement preparedStatement = connection.prepareStatement(ConsultaProfesor.borrarProfesoresid(id))) {
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Registro eliminado exitosamente.");
            } else {
                System.out.println("Algo salió mal.");
            }
        }
    }

    @Override
    public List<ProfesorDTO> listar() throws SQLException {
        List<ProfesorDTO> listaProfesores = new ArrayList<>();
        try (Connection con = conexionBD.getConnecion();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(ConsultaProfesor.obtenerProfesores())) {

            while (resultSet.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(resultSet.getInt("id"));
                profesor.setNombre(resultSet.getString("nombre"));
                profesor.setEdad(resultSet.getInt("edad"));
                profesor.setFacultad(resultSet.getString("facultad"));
                profesor.setAsignatura(resultSet.getString("asignatura"));

                // Convertir la entidad Profesor a DTO usando el MapHandler
                ProfesorDTO profesorDTO = MapHandler.profesorToDto(profesor);
                listaProfesores.add(profesorDTO);
            }
        }
        return listaProfesores;
    }
}
