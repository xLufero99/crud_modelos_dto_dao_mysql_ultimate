<%@ page import="modelo.dto.EstudianteDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Estudiantes</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Lista de Estudiantes</h1>

        <% 
            // Recuperar la lista de estudiantes desde el request
            List<EstudianteDTO> estudiantes = (List<EstudianteDTO>) request.getAttribute("estudiantes");
            
            if (estudiantes == null) {
                out.println("<div class='alert alert-warning'>La lista de estudiantes es null. Revisa que el atributo 'estudiantes' se esté pasando correctamente.</div>");
            } else if (estudiantes.isEmpty()) {
                out.println("<div class='alert alert-info'>No hay estudiantes en la lista.</div>");
            } else {
                out.println("<div class='alert alert-success'>Estudiantes recibidos correctamente: " + estudiantes.size() + "</div>");
        %>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Facultad</th>
                    <th>Semestre</th>
                    <th>Promedio</th>
                    <th>Carrera</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for (EstudianteDTO estudiante : estudiantes) { 
                %>
                <tr>
                    <td><%= estudiante.getId() %></td>
                    <td><%= estudiante.getNombre() %></td>
                    <td><%= estudiante.getEdad() %></td>
                    <td><%= estudiante.getFacultad() %></td>
                    <td><%= estudiante.getSemestre() %></td>
                    <td><%= estudiante.getPromedio() %></td>
                    <td><%= estudiante.getCarrera() %></td>
                </tr>
                <% 
                    } // Fin del bucle
                %>
            </tbody>
        </table>

        <% 
            } // Cierre del bloque que verifica si hay estudiantes
        %>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
