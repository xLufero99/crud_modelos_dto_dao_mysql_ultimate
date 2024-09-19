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

@WebServlet("/ProfesorActualizarServlet")
public class ProfesorActualizarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String facultad = request.getParameter("facultad");
        String asignatura = request.getParameter("asignatura");

        // Crear un objeto ProfesorDTO con los valores recibidos
        ProfesorDTO profesor = new ProfesorDTO();
        profesor.setId(id);
        profesor.setNombre(nombre);
        profesor.setEdad(edad);
        profesor.setFacultad(facultad);
        profesor.setAsignatura(asignatura);

        // Instanciar el DAO
        ProfesorDAO profesorDAO = new ProfesorDAO();
        try {
            // Utilizar el método actualizar del DAO con el DTO creado
            profesorDAO.actualizar(profesor);
            request.setAttribute("mensaje", "Profesor actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Ocurrió un error al actualizar el profesor.");
        }

        // Redirigir a la vista con el mensaje correspondiente
        request.getRequestDispatcher("/ProfesorResultado.jsp").forward(request, response);
    }
}
