package servlets.Profesor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.ProfesorDAO;
import modelo.dto.ProfesorDTO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProfesorBuscarServlet")
public class ProfesorBuscarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProfesorDAO profesorDAO = new ProfesorDAO();
        try {
            ProfesorDTO profesor = profesorDAO.leer(id);
            if (profesor != null) {
                request.setAttribute("profesor", profesor);
                request.getRequestDispatcher("/ProfesorResultado.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "No se encontró el profesor con ID: " + id);
                request.getRequestDispatcher("/ProfesorResultado.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Ocurrió un error al buscar el profesor.");
            request.getRequestDispatcher("/ProfesorResultado.jsp").forward(request, response);
        }
    }
}
