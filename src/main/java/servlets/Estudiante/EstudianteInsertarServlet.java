package servlets.Estudiante;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.EstudianteDAO;
import modelo.dto.EstudianteDTO;

import java.io.IOException;
import java.sql.SQLException;


/**
 * Servlet implementation class EstudianteInsertarServlet
 */
@WebServlet("/EstudianteInsertarServlet")
public class EstudianteInsertarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstudianteInsertarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    int id = Integer.parseInt(request.getParameter("id"));
	    String nombre = request.getParameter("nombre");
	    int edad = Integer.parseInt(request.getParameter("edad"));
	    String facultad = request.getParameter("facultad");
	    int semestre = Integer.parseInt(request.getParameter("semestre"));
	    int promedio = Integer.parseInt(request.getParameter("promedio"));
	    String carrera = request.getParameter("carrera");

	    // Crear objeto EstudianteDTO
	    EstudianteDTO estudiante = new EstudianteDTO();
	    estudiante.setId(id);
	    estudiante.setNombre(nombre);
	    estudiante.setEdad(edad);
	    estudiante.setFacultad(facultad);
	    estudiante.setSemestre(semestre);
	    estudiante.setPromedio(promedio);
	    estudiante.setCarrera(carrera);

	    EstudianteDAO estudianteDAO = new EstudianteDAO();
	    try {
	        estudianteDAO.crear(estudiante); // Llama al método crear con el objeto DTO
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
