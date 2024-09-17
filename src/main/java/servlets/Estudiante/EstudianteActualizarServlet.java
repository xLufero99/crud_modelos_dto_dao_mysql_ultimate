package servlets.Estudiante;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.EstudianteDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EstudianteActualizarServlet")
public class EstudianteActualizarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String facultad = request.getParameter("facultad");
        int semestre = Integer.parseInt(request.getParameter("semestre"));
        int promedio = Integer.parseInt(request.getParameter("promedio"));
        String carrera = request.getParameter("carrera");

        EstudianteDAO estudianteDAO = new EstudianteDAO();
        try {
            estudianteDAO.actualizarEstudiante(id, nombre, edad, facultad, semestre, promedio, carrera);
            request.setAttribute("mensaje", "Estudiante actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Ocurrió un error al actualizar el estudiante.");
        }
        request.getRequestDispatcher("/EstudianteResultado.jsp").forward(request, response);
    }
}
