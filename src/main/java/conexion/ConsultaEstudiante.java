package conexion;

public class ConsultaEstudiante {
    // Consulta para insertar un nuevo estudiante
    public static String insertarEstudiantes() {
        return "INSERT INTO Estudiantes (id, nombre, edad, facultad, semestre, promedio, carrera) \r\n"
        		+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
    }

    // Consulta para obtener todos los registros de estudiantes
    public static String obtenerEstudiantes() {
        return "SELECT * FROM Estudiantes";
    }

    // Consulta para obtener el registro de un estudiante por ID
    public static String obtenerEstudiantePorId() {
        return "SELECT * FROM Estudiantes WHERE id = ?";
    }

    // Consulta para eliminar un estudiante por ID
    public static String borrarEstudiantesid(int id) {
        return "DELETE FROM Estudiantes WHERE id = " + id;
    }

    
    public static String actualizarEstudiantes() {
        return "UPDATE Estudiantes SET nombre = ?, edad = ?, facultad = ?, semestre = ?, promedio = ?, carrera = ? WHERE id = ?";
    }

}

