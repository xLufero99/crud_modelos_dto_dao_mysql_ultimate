<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Profesor</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Registrar Profesor</h1>
        <form action="ProfesorInsertarServlet" method="post">
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
                <label for="asignatura">Asignatura:</label> <!-- Cambié asignaturas a asignatura -->
                <input type="text" class="form-control" id="asignatura" name="asignatura" required> <!-- Cambié el name a asignatura -->
            </div>

            <button type="submit" class="btn btn-primary">Insertar Profesor</button>
        </form>
        
        <!-- Botón para volver al menú de estudiantes -->
        <div class="mt-4">
            <a href="menuProfesores.jsp" class="btn btn-secondary">Volver al Menú de Profesores</a>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
