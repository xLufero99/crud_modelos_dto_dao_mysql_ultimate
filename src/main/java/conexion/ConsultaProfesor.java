package conexion;

public class ConsultaProfesor {
    // Consulta para insertar un nuevo profesor
    public static String insertarProfesores() {
        return "INSERT INTO Profesores (id, nombre, edad, facultad, asignatura) \r\n"
                + "VALUES (?, ?, ?, ?, ?);";
    }

    // Consulta para obtener todos los registros de profesores
    public static String obtenerProfesores() {
        return "SELECT * FROM Profesores";
    }

    // Consulta para obtener el registro de un profesor por ID
    public static String obtenerProfesorPorId() {
        return "SELECT * FROM Profesores WHERE id = ?";
    }

    // Consulta para eliminar un profesor por ID
    public static String borrarProfesoresid(int id) {
        return "DELETE FROM Profesores WHERE id = " + id;
    }

    // Consulta para actualizar el registro de un profesor por ID
    public static String actualizarProfesores() {
        return "UPDATE Profesores SET nombre = ?, edad = ?, facultad = ?, asignatura = ? WHERE id = ?";
    }
}
