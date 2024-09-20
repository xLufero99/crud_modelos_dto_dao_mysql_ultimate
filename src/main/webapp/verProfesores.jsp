<%@ page import="modelo.dto.ProfesorDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Profesores</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Lista de Profesores</h1>

        <% 
            // Recuperar la lista de profesores desde el request
            List<ProfesorDTO> profesores = (List<ProfesorDTO>) request.getAttribute("profesores");
            
            if (profesores == null) {
                out.println("<div class='alert alert-warning'>La lista de profesores es null. Revisa que el atributo 'profesores' se esté pasando correctamente.</div>");
            } else if (profesores.isEmpty()) {
                out.println("<div class='alert alert-info'>No hay profesores en la lista.</div>");
            } else {
                out.println("<div class='alert alert-success'>Profesores recibidos correctamente: " + profesores.size() + "</div>");
        %>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Facultad</th>
                    <th>Asignatura</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for (ProfesorDTO profesor : profesores) { 
                %>
                <tr>
                    <td><%= profesor.getId() %></td>
                    <td><%= profesor.getNombre() %></td>
                    <td><%= profesor.getEdad() %></td>
                    <td><%= profesor.getFacultad() %></td>
                    <td><%= profesor.getAsignatura() %></td>
                </tr>
                <% 
                    } // Fin del bucle
                %>
            </tbody>
        </table>

        <% 
            } // Cierre del bloque que verifica si hay profesores
        %>
        <div class="mt-4">
            <a href="menuProfesores.jsp" class="btn btn-secondary">Volver al Menú de Profesores</a>
        </div>
    </div>


    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
