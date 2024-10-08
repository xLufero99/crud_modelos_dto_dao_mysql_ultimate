package modelo.entiedades;

public class Estudiante extends Persona {
	int semestre;
	int promedio;
	String carrera;
	public Estudiante() {
		super();
	}
	public Estudiante(int semestre, int promedio, String carrera) {
		super();
		this.semestre = semestre;
		this.promedio = promedio;
		this.carrera = carrera;
	}
	public Estudiante(String nombre, String facultad, int id, int edad) {
		super(nombre, facultad, id, edad);
		
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
	
}
