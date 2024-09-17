package servlets.Profesor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.ProfesorDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProfesorActualizarServlet")
public class ProfesorActualizarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String facultad = request.getParameter("facultad");
        String asignatura = request.getParameter("asignatura");

        ProfesorDAO profesorDAO = new ProfesorDAO();
        try {
            profesorDAO.actualizarProfesor(id, nombre, edad, facultad, asignatura);
            request.setAttribute("mensaje", "Profesor actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Ocurrió un error al actualizar el profesor.");
        }
        request.getRequestDispatcher("/ProfesorResultado.jsp").forward(request, response);
    }
}
