<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Estudiante</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Registrar Estudiante</h1>

        <!-- Mostrar mensaje -->
        <c:if test="${not empty mensaje}">
            <div class="alert alert-info">${mensaje}</div>
        </c:if>

        <form action="EstudianteInsertarServlet" method="post">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="id" name="id" required>
            </div>

            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>

            <div class="form-group">
                <label for="edad">Edad:</label>
                <input type="number" class="form-control" id="edad" name="edad" required>
            </div>

            <div class="form-group">
                <label for="facultad">Facultad:</label>
                <input type="text" class="form-control" id="facultad" name="facultad" required>
            </div>

            <div class="form-group">
                <label for="semestre">Semestre:</label>
                <input type="number" class="form-control" id="semestre" name="semestre" required>
            </div>

            <div class="form-group">
                <label for="promedio">Promedio:</label>
                <input type="number" class="form-control" id="promedio" name="promedio" required>
            </div>

            <div class="form-group">
                <label for="carrera">Carrera:</label>
                <input type="text" class="form-control" id="carrera" name="carrera" required>
            </div>

            <button type="submit" class="btn btn-primary">Insertar Estudiante</button>
        </form>

        <!-- Botón para volver al menú de estudiantes -->
        <div class="mt-4">
            <a href="menuEstudiantes.jsp" class="btn btn-secondary">Volver al Menú de Estudiantes</a>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
