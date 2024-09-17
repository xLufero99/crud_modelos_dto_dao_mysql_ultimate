<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
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
        <h1 class="text-center">Sistema de Gestión de Estudiantes</h1>
        <div class="text-center">
            <a class="btn btn-primary" href="EstudianteInsertar.jsp">Ingresar Estudiante</a>
            <a class="btn btn-secondary" href="EstudianteVertServlet">Ver Estudiantes</a>
            <a class="btn btn-info" href="EstudianteBuscar.jsp">Buscar Estudiante por ID</a>
            <a class="btn btn-warning" href="EstudianteBuscarActualizar.jsp">Actualizar Estudiante</a>
            <a class="btn btn-danger" href="EstudianteEliminar.jsp">Borrar Estudiante</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
