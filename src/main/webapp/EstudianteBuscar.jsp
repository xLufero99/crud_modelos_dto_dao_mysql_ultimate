<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buscar Estudiante</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Buscar Estudiante</h1>
        <form action="EstudianteBuscarServlet" method="post">
            <div class="form-group">
                <label for="id">ID del Estudiante:</label>
                <input type="number" id="id" name="id" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
        </form>

        <!-- Botón para volver al menú de estudiantes -->
        <div class="mt-3">
            <a href="menuEstudiantes.jsp" class="btn btn-secondary">Volver al Menú de Estudiantes</a>
        </div>
    </div>
</body>
</html>
