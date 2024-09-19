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
import java.util.List;

@WebServlet("/EstudianteVertServlet")
public class EstudianteVertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        try {
            List<EstudianteDTO> listaEstudiantes = estudianteDAO.listar();
            if (listaEstudiantes != null) {
                request.setAttribute("estudiantes", listaEstudiantes);
            }
            request.getRequestDispatcher("verEstudiantes.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

