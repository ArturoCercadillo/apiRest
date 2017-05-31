package es.curso.model;

public class Direcciones {
	
	int id;
	String calle;
	String municipio;
	String provincia;
	int alumnoID;

	public Direcciones() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getAlumnoID() {
		return alumnoID;
	}

	public void setAlumnoID(int alumnoID) {
		this.alumnoID = alumnoID;
	}
	
	

}
