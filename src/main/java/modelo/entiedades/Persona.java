package modelo.entiedades;

public abstract class Persona {

	String nombre;
	String Facultad;
	int id;
	int edad;
	public Persona() {
		super();
	}
	public Persona(String nombre, String facultad, int id, int edad) {
		super();
		this.nombre = nombre;
		Facultad = facultad;
		this.id = id;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFacultad() {
		return Facultad;
	}
	public void setFacultad(String facultad) {
		Facultad = facultad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	
	
}
