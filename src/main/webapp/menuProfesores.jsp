<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Profesores</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 50px;
        }
        .btn {
            margin: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Sistema de Gestión de Profesores</h1>
        <div class="text-center">
            <a class="btn btn-primary" href="ProfesorInsertar.jsp">Ingresar Profesor</a>
            <a class="btn btn-secondary" href="ProfesorVerServlet">Ver Profesores</a>
            <a class="btn btn-info" href="ProfesorBuscar.jsp">Buscar Profesor por ID</a>
            <a class="btn btn-warning" href="ProfesorBuscarActualizar.jsp">Actualizar Profesor</a>
            <a class="btn btn-danger" href=" ProfesorEliminar.jsp">Borrar Profesor</a>
        </div>
    </div>
<!-- Botón para volver al Menú Principal -->
        <div class="text-center mt-4">
            <a class="btn btn-dark" href="index.jsp">Menú Principal</a>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
