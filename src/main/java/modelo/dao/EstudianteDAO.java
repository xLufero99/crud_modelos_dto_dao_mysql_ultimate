package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.EstudianteDTO;
import modelo.entiedades.Estudiante;
import conexion.ConexionBD;
import conexion.ConsultaEstudiante;
import modelo.entiedades.MapHandler;

public class EstudianteDAO implements interfaceDao<EstudianteDTO> {
    private ConexionBD conexionBD;

    public EstudianteDAO() {
        this.conexionBD = new ConexionBD();  // Asegúrate de que esto no es null
    }

    @Override
    public void crear(EstudianteDTO entidad) throws SQLException {
        Estudiante estudiante = MapHandler.dtoToEstudiante(entidad);

        try (Connection con = conexionBD.getConnecion(); 
             PreparedStatement preparedStatement = con.prepareStatement(ConsultaEstudiante.insertarEstudiantes())) {

            preparedStatement.setInt(1, estudiante.getId());
            preparedStatement.setString(2, estudiante.getNombre());
            preparedStatement.setInt(3, estudiante.getEdad());
            preparedStatement.setString(4, estudiante.getFacultad());
            preparedStatement.setInt(5, estudiante.getSemestre());
            preparedStatement.setInt(6, estudiante.getPromedio());
            preparedStatement.setString(7, estudiante.getCarrera());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Registro Exitoso");
            } else {
                System.out.println("Registro Fallido");
            }
        }
    }

    @Override
    public EstudianteDTO leer(int id) throws SQLException {
        EstudianteDTO estudianteDTO = null;
        try (Connection connection = conexionBD.getConnecion();
             PreparedStatement preparedStatement = connection.prepareStatement(ConsultaEstudiante.obtenerEstudiantePorId())) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setId(resultSet.getInt("id"));
                    estudiante.setNombre(resultSet.getString("nombre"));
                    estudiante.setEdad(resultSet.getInt("edad"));
                    estudiante.setFacultad(resultSet.getString("facultad"));
                    estudiante.setSemestre(resultSet.getInt("semestre"));
                    estudiante.setPromedio(resultSet.getInt("promedio"));
                    estudiante.setCarrera(resultSet.getString("carrera"));

                    estudianteDTO = MapHandler.estudianteToDto(estudiante);
                }
            }
        }
        return estudianteDTO;
    }

    @Override
    public void actualizar(EstudianteDTO entidad) throws SQLException {
        Estudiante estudiante = MapHandler.dtoToEstudiante(entidad);

        try (Connection connection = conexionBD.getConnecion();
             PreparedStatement preparedStatement = connection.prepareStatement(ConsultaEstudiante.actualizarEstudiantes())) {

            preparedStatement.setString(1, estudiante.getNombre());
            preparedStatement.setInt(2, estudiante.getEdad());
            preparedStatement.setString(3, estudiante.getFacultad());
            preparedStatement.setInt(4, estudiante.getSemestre());
            preparedStatement.setInt(5, estudiante.getPromedio());
            preparedStatement.setString(6, estudiante.getCarrera());
            preparedStatement.setInt(7, estudiante.getId());

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
             PreparedStatement preparedStatement = connection.prepareStatement(ConsultaEstudiante.borrarEstudiantesid(id))) {
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Registro eliminado exitosamente.");
            } else {
                System.out.println("Eliminación fallida.");
            }
        }
    }

    @Override
    public List<EstudianteDTO> listar() throws SQLException {
        List<EstudianteDTO> listaEstudiantes = new ArrayList<>();

        String sql = "SELECT * FROM Estudiantes";
        try (Connection con = conexionBD.getConnecion();
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(resultSet.getInt("id"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setEdad(resultSet.getInt("edad"));
                estudiante.setFacultad(resultSet.getString("facultad"));
                estudiante.setSemestre(resultSet.getInt("semestre"));
                estudiante.setPromedio(resultSet.getInt("promedio"));
                estudiante.setCarrera(resultSet.getString("carrera"));

                EstudianteDTO estudianteDTO = MapHandler.estudianteToDto(estudiante);
                listaEstudiantes.add(estudianteDTO);
            }
        }
        return listaEstudiantes;
    }
}
