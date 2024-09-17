package modelo.entiedades;

public class Profesor extends Persona {
	
	String asignatura;

	public Profesor() {
		super();
	}

	public Profesor(String asignatura) {
		super();
		this.asignatura = asignatura;
	}

	public Profesor(String nombre, String facultad, int id, int edad) {
		super(nombre, facultad, id, edad);
		
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	
	
	
	
	
}
