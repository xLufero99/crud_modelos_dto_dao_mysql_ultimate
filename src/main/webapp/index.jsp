<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Estudiantes y Profesores</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 50px;
        }
        .btn {
            width: 100%;
            margin-bottom: 10px;
        }
        .image-center {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 30px 0;
        }
        .image-center img {
            max-width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Gestión de Estudiantes y Profesores</h1>
        
        <!-- Botones de gestión -->
        <div class="row">
            <div class="col-md-6">
                <a class="btn btn-primary" href="menuEstudiantes.jsp">Gestionar Estudiantes</a>
            </div>
            <div class="col-md-6">
                <a class="btn btn-secondary" href="menuProfesores.jsp">Gestionar Profesores</a>
            </div>
        </div>

       <div style="text-align: center; margin-top: 20px;">
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAVHWLGcNzCRyJ7vf8aH0vY7NkhAMtMRhfNw&s" 
         alt="Descripción de la imagen" 
         style="width: 300px; height: auto;">
</div>
       

    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
