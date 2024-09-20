package modelo.entiedades;

import modelo.dto.ProfesorDTO;
import modelo.dto.EstudianteDTO;
import modelo.entiedades.Profesor;
import modelo.entiedades.Estudiante;

public class MapHandler {
    public static Profesor dtoToProfesor(ProfesorDTO dto) {
        if (dto == null) return null;

        Profesor profesor = new Profesor();
        System.out.println("Convirtiendo DTO a Profesor: " + dto);
        profesor.setId(dto.getId());
        profesor.setNombre(dto.getNombre());
        profesor.setEdad(dto.getEdad());
        profesor.setFacultad(dto.getFacultad());
        profesor.setAsignatura(dto.getAsignatura());
        return profesor;
    }

    public static ProfesorDTO profesorToDto(Profesor profesor) {
        if (profesor == null) return null;

        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(profesor.getId());
        dto.setNombre(profesor.getNombre());
        dto.setEdad(profesor.getEdad());
        dto.setFacultad(profesor.getFacultad());
        dto.setAsignatura(profesor.getAsignatura());
        return dto;
    }

    // Métodos para convertir Estudiante y EstudianteDTO
    public static Estudiante dtoToEstudiante(EstudianteDTO dto) {
        if (dto == null) return null;

        Estudiante estudiante = new Estudiante();
        System.out.println("Convirtiendo DTO a Estudiante: " + dto);
        estudiante.setId(dto.getId());
        estudiante.setNombre(dto.getNombre());
        estudiante.setEdad(dto.getEdad());
        estudiante.setFacultad(dto.getFacultad());
        estudiante.setSemestre(dto.getSemestre()); // Asegúrate de manejar este atributo
        estudiante.setPromedio(dto.getPromedio()); // Asegúrate de manejar este atributo
        estudiante.setCarrera(dto.getCarrera()); // Asumiendo que tienes este atributo
        return estudiante;
    }

    public static EstudianteDTO estudianteToDto(Estudiante estudiante) {
        if (estudiante == null) return null;

        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setEdad(estudiante.getEdad());
        dto.setFacultad(estudiante.getFacultad());
        dto.setSemestre(estudiante.getSemestre()); // Asegúrate de manejar este atributo
        dto.setPromedio(estudiante.getPromedio()); // Asegúrate de manejar este atributo
        dto.setCarrera(estudiante.getCarrera()); // Asumiendo que tienes este atributo
        return dto;
    }
}
