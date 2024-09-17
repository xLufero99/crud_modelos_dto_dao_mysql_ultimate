<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.dto.ProfesorDTO" %>
<!DOCTYPE html>
<html lang="es">
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
            ProfesorDTO profesor = (ProfesorDTO) request.getAttribute("profesor");
            if (profesor != null) {
        %>
        <table class="table table-bordered mt-3">
            <tr>
                <th>ID</th>
                <td><%= profesor.getId() %></td>
            </tr>
            <tr>
                <th>Nombre</th>
                <td><%= profesor.getNombre() %></td>
            </tr>
            <tr>
                <th>Edad</th>
                <td><%= profesor.getEdad() %></td>
            </tr>
            <tr>
                <th>Facultad</th>
                <td><%= profesor.getFacultad() %></td>
            </tr>
            <tr>
                <th>Asignatura</th>
                <td><%= profesor.getAsignatura() %></td>
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
