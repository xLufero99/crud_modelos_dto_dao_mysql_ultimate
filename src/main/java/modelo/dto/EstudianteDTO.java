package modelo.dto;

public class EstudianteDTO {

	///cambiar eso tan feo si se puede xd
	private int id;
	private String nombre;
	private int edad;
	private String facultad;
	private int semestre;
	private int promedio;
	private String carrera;


	
	
	public EstudianteDTO() {
		
	}
	

	
	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getFacultad() {
		return facultad;
	}


	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}


	public int getSemestre() {
		return semestre;
	}


	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}


	public int getPromedio() {
		return promedio;
	}


	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}


	public String getCarrera() {
		return carrera;
	}


	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	@Override
	public String toString() {
	    return "Estudiante [id=" + id 
	           + ", nombre=" + nombre 
	           + ", edad=" + edad 
	           + ", facultad=" + facultad 
	           + ", semestre=" + semestre 
	           + ", promedio=" + promedio 
	           + ", carrera=" + carrera 
	           + "]";
	}

	
	
	
	
	
	
	
	
}
