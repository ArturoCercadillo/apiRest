package es.curso.model;

public class Asignatura {
	
	private int id;
	public String descripcion;
	public int idProfesor;
	
	
	public Asignatura() {
		super();
	}




	public Asignatura(int id, String descripcion, int idProfesor) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.idProfesor = idProfesor;
	}
	
	


	public Asignatura(String descripcion, int idProfesor) {
		super();
		this.descripcion = descripcion;
		this.idProfesor = idProfesor;
	}




	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", descripcion=" + descripcion + ", idProfesor=" + idProfesor + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getIdProfesor() {
		return idProfesor;
	}


	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	
	
}


