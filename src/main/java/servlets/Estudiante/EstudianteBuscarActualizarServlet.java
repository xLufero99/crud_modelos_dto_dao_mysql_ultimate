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

@WebServlet("/EstudianteBuscarActualizarServlet")
public class EstudianteBuscarActualizarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        try {
            EstudianteDTO estudiante = estudianteDAO.obtenerEstudiantePorId(id);
            if (estudiante != null) {
                request.setAttribute("estudiante", estudiante);
                request.getRequestDispatcher("/EstudianteActualizar.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "Estudiante no encontrado con ID: " + id);
                request.getRequestDispatcher("/EstudianteResultado.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Ocurrió un error al buscar el estudiante.");
            request.getRequestDispatcher("/EstudianteResultado.jsp").forward(request, response);
        }
    }
}
