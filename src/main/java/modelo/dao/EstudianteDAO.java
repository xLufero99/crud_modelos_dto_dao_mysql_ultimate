package modelo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.dto.EstudianteDTO;
import conexion.ConexionBD;
import conexion.ConsultaEstudiante;

public class EstudianteDAO {
	private ConexionBD conexionBD;
	public EstudianteDAO() {
		this.conexionBD = new ConexionBD();  // Asegúrate de que esto no es null
        ConexionBD conexionBD = new ConexionBD(); // Esto podría lanzar el RuntimeException
    }
	Scanner sc = new Scanner(System.in);
		
	
	public void insertarEstudiante(int id, String nombre, int edad, String facultad, int semestre, int promedio, String carrera) throws SQLException {
        // Asume que conexionBD es una clase que proporciona la conexión a la base de datos
        try (Connection con = conexionBD.getConnecion(); 
             PreparedStatement preparedStatement = con.prepareStatement(ConsultaEstudiante.insertarEstudiantes())) {

            // Establecer los valores del PreparedStatement
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nombre); // 
            preparedStatement.setInt(3, edad);
            preparedStatement.setString(4, facultad); // 
            preparedStatement.setInt(5, semestre);
            preparedStatement.setInt(6, promedio);
            preparedStatement.setString(7, carrera); // 

            // Ejecutar la actualización
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Registro Exitoso");
            } else {
                System.out.println("Registro Fallido");
            }
        }
    }

	
	
	//ver todos los estudiantes
	
	 public List<EstudianteDTO> obtenerEstudiantes() throws SQLException {
	        List<EstudianteDTO> listaEstudiantes = new ArrayList<>();

	        String sql = "SELECT * FROM Estudiantes";
	        try (Connection con = conexionBD.getConnecion();
	             Statement statement = con.createStatement();
	             ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                EstudianteDTO estudiante = new EstudianteDTO();
	                estudiante.setId(resultSet.getInt("id"));
	                estudiante.setNombre(resultSet.getString("nombre"));
	                estudiante.setEdad(resultSet.getInt("edad"));
	                estudiante.setFacultad(resultSet.getString("facultad"));
	                estudiante.setSemestre(resultSet.getInt("semestre"));
	                estudiante.setPromedio(resultSet.getInt("promedio"));
	                estudiante.setCarrera(resultSet.getString("carrera"));

	                listaEstudiantes.add(estudiante);
	            }
	        }
	        return listaEstudiantes;
	    }
	
	//terminado solo falta arrglar machetazos
	 
	 public EstudianteDTO obtenerEstudiantePorId(int id) throws SQLException {
		    EstudianteDTO estudiante = null;
		    try (Connection connection = conexionBD.getConnecion();
		         PreparedStatement preparedStatement = connection.prepareStatement(ConsultaEstudiante.obtenerEstudiantePorId())) {
		        preparedStatement.setInt(1, id);
		        try (ResultSet resultSet = preparedStatement.executeQuery()) {
		            if (resultSet.next()) {
		                estudiante = new EstudianteDTO();
		                estudiante.setId(resultSet.getInt("id"));
		                estudiante.setNombre(resultSet.getString("nombre"));
		                estudiante.setEdad(resultSet.getInt("edad"));
		                estudiante.setFacultad(resultSet.getString("facultad"));
		                estudiante.setSemestre(resultSet.getInt("semestre"));
		                estudiante.setPromedio(resultSet.getInt("promedio"));
		                estudiante.setCarrera(resultSet.getString("carrera"));
		            }
		        }
		    }
		    return estudiante;
		}

	 
	 
	 //arriba no tocar
	 
	 public void actualizarEstudiante(int id, String nombre, int edad, String facultad, int semestre, int promedio, String carrera) throws SQLException {
		    try (Connection connection = conexionBD.getConnecion();
		         PreparedStatement preparedStatement = connection.prepareStatement(ConsultaEstudiante.actualizarEstudiantes())) {

		        // Establecer los valores del PreparedStatement
		        preparedStatement.setString(1, nombre);
		        preparedStatement.setInt(2, edad);
		        preparedStatement.setString(3, facultad);
		        preparedStatement.setInt(4, semestre);
		        preparedStatement.setInt(5, promedio);
		        preparedStatement.setString(6, carrera);
		        preparedStatement.setInt(7, id);

		        // Ejecutar la actualización
		        int rows = preparedStatement.executeUpdate();
		        if (rows > 0) {
		            System.out.println("Registro actualizado exitosamente.");
		        } else {
		            System.out.println("Actualización fallida.");
		        }
		    }
		}

		// =>delete Record Of Entire one Row
		public void borrarEstudiante(int id) throws SQLException {
			try (Connection connection = conexionBD.getConnecion(); Statement statement = connection.createStatement();) {
				int rows = statement.executeUpdate(ConsultaEstudiante.borrarEstudiantesid(id));
				if (rows > 0) {
					System.out.println("Record deleted successfully");
				} else {
					System.out.println("Something went wrong");
				}
			}
		}
			
			
	

}
