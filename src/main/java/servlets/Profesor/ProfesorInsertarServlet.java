package servlets.Profesor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.ProfesorDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProfesorInsertarServlet")
public class ProfesorInsertarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String facultad = request.getParameter("facultad");
        String asignaturas = request.getParameter("asignaturas");

        ProfesorDAO profesorDAO = new ProfesorDAO();
        String mensaje;
        try {
            profesorDAO.insertarProfesor(id, nombre, edad, facultad, asignaturas);
            mensaje = "Profesor insertado exitosamente.";
        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al insertar el profesor.";
        }

       
    }
}
