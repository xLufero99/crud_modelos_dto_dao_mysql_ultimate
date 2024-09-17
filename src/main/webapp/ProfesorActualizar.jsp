<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelo.dto.ProfesorDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Profesor</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Actualizar Profesor</h1>
        <%
            ProfesorDTO profesor = (ProfesorDTO) request.getAttribute("profesor");
            if (profesor != null) {
        %>
        <form action="ProfesorActualizarServlet" method="post">
            <input type="hidden" name="id" value="<%= profesor.getId() %>">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" value="<%= profesor.getNombre() %>" required>
            </div>
            <div class="form-group">
                <label for="edad">Edad:</label>
                <input type="number" id="edad" name="edad" class="form-control" value="<%= profesor.getEdad() %>" required>
            </div>
            <div class="form-group">
                <label for="facultad">Facultad:</label>
                <input type="text" id="facultad" name="facultad" class="form-control" value="<%= profesor.getFacultad() %>" required>
            </div>
            <div class="form-group">
                <label for="asignatura">Asignatura:</label>
                <input type="text" id="asignatura" name="asignatura" class="form-control" value="<%= profesor.getAsignatura() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Actualizar</button>
        </form>
        <a href="index.jsp" class="btn btn-secondary mt-3">Volver al Inicio</a>
        <%
            } else {
        %>
        <p>Profesor no encontrado.</p>
        <a href="index.jsp" class="btn btn-secondary mt-3">Volver al Inicio</a>
        <%
            }
        %>
    </div>
</body>
</html>
