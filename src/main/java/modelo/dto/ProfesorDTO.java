package modelo.dto;

public class ProfesorDTO {
	private int id;
	private String nombre;
	private int edad;
	private String facultad;
	private String asignatura;

	
	
	public ProfesorDTO() {
		
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


	public String getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}




	@Override
	public String toString() {
	    return "Estudiante [id=" + id 
	           + ", nombre=" + nombre 
	           + ", edad=" + edad 
	           + ", facultad=" + facultad 
	           + ", asignatura=" + asignatura 
	           + "]";
	}

}
