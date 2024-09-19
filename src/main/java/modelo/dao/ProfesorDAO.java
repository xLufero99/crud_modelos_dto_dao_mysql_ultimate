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

public class ProfesorDAO implements interfaceDao<ProfesorDTO> {
    private ConexionBD conexionBD;

    public ProfesorDAO() {
        this.conexionBD = new ConexionBD();  // Asegúrate de que esto no sea null
    }
    
    /////<<----------------------------------------------->>
    
    /////arreglado machetazo DTO jsjs solo esta insertar
       
    /////crear estudiante arreglado
    @Override
    public void crear(ProfesorDTO entidad) throws SQLException {
        try (Connection con = conexionBD.getConnecion(); 
             PreparedStatement preparedStatement = con.prepareStatement(ConsultaProfesor.insertarProfesores())) {

            // Establecer los valores del PreparedStatement utilizando los métodos del DTO
            preparedStatement.setInt(1, entidad.getId());
            preparedStatement.setString(2, entidad.getNombre());
            preparedStatement.setInt(3, entidad.getEdad());
            preparedStatement.setString(4, entidad.getFacultad());
            preparedStatement.setString(5, entidad.getAsignatura());

            // Ejecutar la actualización
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Registro Exitoso");
            } else {
                System.out.println("Registro Fallido");
            }
        }
    }
    
    
   
///buscar por id arreglado
	@Override
	public ProfesorDTO leer(int id) throws SQLException {
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
	
	
	///actualizar

	@Override
	public void actualizar(ProfesorDTO entidad) throws SQLException {
		try (Connection connection = conexionBD.getConnecion();
	             PreparedStatement preparedStatement = connection.prepareStatement(ConsultaProfesor.actualizarProfesores())) {

	            // Establecer los valores del PreparedStatement
	            preparedStatement.setString(1, entidad.getNombre());
	            preparedStatement.setInt(2, entidad.getEdad());
	            preparedStatement.setString(3, entidad.getFacultad());
	            preparedStatement.setString(4, entidad.getAsignatura());
	            preparedStatement.setInt(5, entidad.getId());

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
		
///ver todos
	@Override
	public List<ProfesorDTO> listar() throws SQLException {
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
}
