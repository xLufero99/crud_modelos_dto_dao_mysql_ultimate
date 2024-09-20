<%@ page import="modelo.dao.EstudianteDAO" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Eliminar Estudiante</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1>Eliminar Estudiante</h1>
        <form action="EstudianteEliminarServlet" method="post">
            <div class="form-group">
                <label for="id">ID del Estudiante:</label>
                <input type="text" class="form-control" id="id" name="id" required>
            </div>
            <button type="submit" class="btn btn-danger">Eliminar Estudiante</button>
        </form>
        
        <hr>
        
        <% 
            String mensaje = (String) request.getAttribute("mensaje");
            if (mensaje != null) {
                %>
                <div class="alert <%= mensaje.contains("exitosamente") ? "alert-success" : "alert-danger" %>" role="alert">
                    <%= mensaje %>
                </div>
                <% 
            }
        %>
        <a href="menuEstudiantes.jsp" class="btn btn-secondary">Volver al Menú de Estudiantes</a>
    </div>
    
</body>
</html>
