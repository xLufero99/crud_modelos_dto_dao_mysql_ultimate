<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.dto.EstudianteDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado de Búsqueda</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Resultado de la Búsqueda</h1>
        <% 
            EstudianteDTO estudiante = (EstudianteDTO) request.getAttribute("estudiante");
            if (estudiante != null) {
        %>
        <table class="table table-bordered mt-3">
            <tr>
                <th>ID</th>
                <td><%= estudiante.getId() %></td>
            </tr>
            <tr>
                <th>Nombre</th>
                <td><%= estudiante.getNombre() %></td>
            </tr>
            <tr>
                <th>Edad</th>
                <td><%= estudiante.getEdad() %></td>
            </tr>
            <tr>
                <th>Facultad</th>
                <td><%= estudiante.getFacultad() %></td>
            </tr>
            <tr>
                <th>Semestre</th>
                <td><%= estudiante.getSemestre() %></td>
            </tr>
            <tr>
                <th>Promedio</th>
                <td><%= estudiante.getPromedio() %></td>
            </tr>
            <tr>
                <th>Carrera</th>
                <td><%= estudiante.getCarrera() %></td>
            </tr>
        </table>
        <% 
            } else {
                String mensaje = (String) request.getAttribute("mensaje");
                if (mensaje != null) {
                    out.println("<div class='alert alert-warning mt-3'>" + mensaje + "</div>");
                }
            }
        %>
        <a href="index.jsp" class="btn btn-primary mt-3">Volver al Inicio</a>
    </div>
</body>
</html>
