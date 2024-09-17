<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.dto.EstudianteDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Estudiante</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Actualizar Estudiante</h1>
        <%
            EstudianteDTO estudiante = (EstudianteDTO) request.getAttribute("estudiante");
            if (estudiante != null) {
        %>
        <form action="EstudianteActualizarServlet" method="post">
            <input type="hidden" name="id" value="<%= estudiante.getId() %>">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" value="<%= estudiante.getNombre() %>" required>
            </div>
            <div class="form-group">
                <label for="edad">Edad:</label>
                <input type="number" id="edad" name="edad" class="form-control" value="<%= estudiante.getEdad() %>" required>
            </div>
            <div class="form-group">
                <label for="facultad">Facultad:</label>
                <input type="text" id="facultad" name="facultad" class="form-control" value="<%= estudiante.getFacultad() %>" required>
            </div>
            <div class="form-group">
                <label for="semestre">Semestre:</label>
                <input type="number" id="semestre" name="semestre" class="form-control" value="<%= estudiante.getSemestre() %>" required>
            </div>
            <div class="form-group">
                <label for="promedio">Promedio:</label>
                <input type="number" id="promedio" name="promedio" class="form-control" value="<%= estudiante.getPromedio() %>" required>
            </div>
            <div class="form-group">
                <label for="carrera">Carrera:</label>
                <input type="text" id="carrera" name="carrera" class="form-control" value="<%= estudiante.getCarrera() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Actualizar</button>
        </form>
        <a href="index.jsp" class="btn btn-secondary mt-3">Volver al Inicio</a>
        <%
            } else {
        %>
        <p>Estudiante no encontrado.</p>
        <a href="index.jsp" class="btn btn-secondary mt-3">Volver al Inicio</a>
        <%
            }
        %>
    </div>
</body>
</html>
