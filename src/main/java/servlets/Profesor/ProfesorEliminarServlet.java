package servlets.Profesor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.ProfesorDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProfesorEliminarServlet")
public class ProfesorEliminarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("ProfesorEliminar.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProfesorDAO profesorDAO = new ProfesorDAO();
        
        try {
            profesorDAO.borrarProfesor(id);
            request.setAttribute("mensaje", "Profesor eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Error al eliminar el profesor.");
        }
        
        request.getRequestDispatcher("ProfesorEliminar.jsp").forward(request, response);
    }
}
