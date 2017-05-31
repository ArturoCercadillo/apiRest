package es.curso.model;

public class Notas {
	int id;
	int alumnoID;
	String calificacion;
	String descripcion;
	int asignaturaID;

	public Notas() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAlumnoID() {
		return alumnoID;
	}

	public void setAlumnoID(int alumnoID) {
		this.alumnoID = alumnoID;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAsignaturaID() {
		return asignaturaID;
	}

	public void setAsignaturaID(int asignaturaID) {
		this.asignaturaID = asignaturaID;
	}

}
