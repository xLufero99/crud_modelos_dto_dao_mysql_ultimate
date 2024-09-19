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

public class EstudianteDAO implements interfaceDao<EstudianteDTO> {
	private ConexionBD conexionBD;
	public EstudianteDAO() {
		this.conexionBD = new ConexionBD();  // Asegúrate de que esto no es null
        ConexionBD conexionBD = new ConexionBD(); // Esto podría lanzar el RuntimeException
    }
	Scanner sc = new Scanner(System.in);
		
	
	//<<-------------------------------------------------------->>
		
		///desde aqui si empiezan el cacaito :D

		@Override
		public void crear(EstudianteDTO entidad) throws SQLException {
		    // Asume que conexionBD es una clase que proporciona la conexión a la base de datos
		    try (Connection con = conexionBD.getConnecion(); 
		         PreparedStatement preparedStatement = con.prepareStatement(ConsultaEstudiante.insertarEstudiantes())) {

		        // Establecer los valores del PreparedStatement utilizando los métodos del DTO
		        preparedStatement.setInt(1, entidad.getId());
		        preparedStatement.setString(2, entidad.getNombre());
		        preparedStatement.setInt(3, entidad.getEdad());
		        preparedStatement.setString(4, entidad.getFacultad());
		        preparedStatement.setInt(5, entidad.getSemestre());
		        preparedStatement.setInt(6, entidad.getPromedio());
		        preparedStatement.setString(7, entidad.getCarrera());

		        // Ejecutar la actualización
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





		@Override
		public void actualizar(EstudianteDTO entidad) throws SQLException{
			try (Connection connection = conexionBD.getConnecion();
			         PreparedStatement preparedStatement = connection.prepareStatement(ConsultaEstudiante.actualizarEstudiantes())) {

			        // Establecer los valores del PreparedStatement
				preparedStatement.setString(1, entidad.getNombre());
				preparedStatement.setInt(2, entidad.getEdad());
				preparedStatement.setString(3, entidad.getFacultad());
				preparedStatement.setInt(4, entidad.getSemestre());
				preparedStatement.setInt(5, entidad.getPromedio());
				preparedStatement.setString(6, entidad.getCarrera());
				preparedStatement.setInt(7, entidad.getId());


			        // Ejecutar la actualización
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
			try (Connection connection = conexionBD.getConnecion(); Statement statement = connection.createStatement();) {
				int rows = statement.executeUpdate(ConsultaEstudiante.borrarEstudiantesid(id));
				if (rows > 0) {
					System.out.println("Record deleted successfully");
				} else {
					System.out.println("Something went wrong");
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
			
		}
			
			



