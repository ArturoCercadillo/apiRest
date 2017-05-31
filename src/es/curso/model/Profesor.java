package es.curso.model;

public class Profesor {
	public int id;
	public String nombre;
	public String apellidos;
	public int despacho;
	
	
	public Profesor() {
		super();
	}
	
	
	public Profesor(int id, String nombre, String apellidos, int despacho) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.despacho = despacho;
	}
	
	public Profesor(String nombre, String apellidos, int despacho) {
		super();
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.despacho = despacho;
	}
	
	//Necesitamos un constructor vacio para la función de editar, ya que antes tendremos que crear profesor vacio para insertarle los valores que nos llegan de su id y poder dibujarlos en el formulario

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getDespacho() {
		return despacho;
	}

	public void setDespacho(int despacho) {
		this.despacho = despacho;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", despacho=" + despacho
				+ "]";
	}
	
	

}
