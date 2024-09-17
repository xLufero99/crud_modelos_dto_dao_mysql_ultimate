package servlets.Estudiante;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.EstudianteDAO;

import java.io.IOException;
import java.sql.SQLException;

	@WebServlet("/EstudianteEliminarServlet")
public class EstudianteEliminarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("EstudianteEliminar.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        
        try {
            estudianteDAO.borrarEstudiante(id);
            request.setAttribute("mensaje", "Estudiante eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el estudiante.");
        }
        
        request.getRequestDispatcher("EstudianteEliminar.jsp").forward(request, response);
    }
}
