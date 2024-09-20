<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buscar Profesor para Actualizar</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Buscar Profesor para Actualizar</h1>
        <form action="ProfesorBuscarActualizarServlet" method="post">
            <div class="form-group">
                <label for="id">ID del Profesor:</label>
                <input type="number" id="id" name="id" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
        </form>
        <a href="menuProfesores.jsp" class="btn btn-secondary mt-3">Volver al Menú de Profesores</a>
    </div>
</body>
</html>
