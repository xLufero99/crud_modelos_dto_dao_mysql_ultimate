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
import java.util.List;

@WebServlet("/ProfesorVerServlet")
public class ProfesorVerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfesorDAO profesorDAO = new ProfesorDAO();
        try {
            List<ProfesorDTO> listaProfesores = profesorDAO.obtenerProfesores();
            if (listaProfesores != null) {
                request.setAttribute("profesores", listaProfesores);
            }
            request.getRequestDispatcher("verProfesores.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Error al obtener la lista de profesores.");
            request.getRequestDispatcher("ProfesorResultado.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
