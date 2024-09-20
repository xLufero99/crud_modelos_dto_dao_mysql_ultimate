package servlets.Profesor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.ProfesorDAO;
import modelo.dto.ProfesorDTO;
import modelo.entiedades.Profesor;
import modelo.entiedades.MapHandler;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProfesorInsertarServlet")
public class ProfesorInsertarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Verificar que se reciban los parámetros correctamente
        String idParam = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String edadParam = request.getParameter("edad");
        String facultad = request.getParameter("facultad");
        String asignatura = request.getParameter("asignatura");

        // Mostrar los parámetros en consola
        System.out.println("ID: " + idParam);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edadParam);
        System.out.println("Facultad: " + facultad);
        System.out.println("Asignatura: " + asignatura);

        // Convertir parámetros a tipos adecuados y manejar posibles excepciones
        int id = 0;
        int edad = 0;
        try {
            id = Integer.parseInt(idParam);
            edad = Integer.parseInt(edadParam);
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir ID o Edad a entero: " + e.getMessage());
            request.setAttribute("mensaje", "Error al ingresar datos: ID y Edad deben ser números.");
            request.getRequestDispatcher("/ProfesorResultado.jsp").forward(request, response);
            return;
        }

        // Crear objeto ProfesorDTO
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(id);
        profesorDTO.setNombre(nombre);
        profesorDTO.setEdad(edad);
        profesorDTO.setFacultad(facultad);
        profesorDTO.setAsignatura(asignatura);

        // Insertar profesor
        ProfesorDAO profesorDAO = new ProfesorDAO();
        String mensaje;
        try {
            profesorDAO.crear(profesorDTO); // Insertar el profesorDTO
            mensaje = "Profesor insertado exitosamente.";
        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al insertar el profesor: " + e.getMessage();
        }

        // Enviar mensaje de éxito o error al JSP
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("/ProfesorResultado.jsp").forward(request, response);
    }
}
