package apiRest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.curso.dao.AlumnoDao;
import es.curso.model.Alumno;
import es.curso.model.Asignatura;

@Path("/alumno")
public class Alumnos {

	private AlumnoDao dao;
	private Alumno alumno;
	private List<Alumno> alumnos;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alumno getAlumno(@PathParam("id") String id) {
		System.out.println(id);
		dao = new AlumnoDao();
		alumno = dao.getAlumnoById(Integer.parseInt(id));

		return alumno;
	}

	@GET
	@Path("/asignaturas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Asignatura> getAsignaturasAlumno(@PathParam("id") String id) {
		System.out.println(id);
		dao = new AlumnoDao();
		ArrayList<Asignatura> listaAsignaturas = dao.creaListaDeAsignaturasDeAlumno(Integer.parseInt(id));
		
		return  listaAsignaturas;
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alumno> getAlumnos() {
		dao = new AlumnoDao();
		alumnos = dao.getAllAlumnos();

		return alumnos;

	}

	@POST
	@Path("/")
	public void addAlumno(@FormParam("dni") String dni, @FormParam("nombre") String nombre,
			@FormParam("apellidos") String apellidos, @FormParam("mes") String mes) {

		Alumno uno = new Alumno();
		uno.dni = dni;
		uno.mes = Integer.parseInt(mes);
		uno.nombre = nombre;
		uno.apellidos = apellidos;

		dao = new AlumnoDao();
		dao.addAlumno(uno);
		System.out.println("añadido: " + uno.toString());
	}

	@PUT
	@Path("/")
	public void editAlumno(@FormParam("id") String id, @FormParam("dni") String dni, @FormParam("nombre") String nombre,
			@FormParam("apellidos") String apellidos, @FormParam("mes") String mes) {

		Alumno uno = new Alumno();
		uno.id = Integer.parseInt(id);
		uno.dni = dni;
		uno.mes = Integer.parseInt(mes);
		uno.nombre = nombre;
		uno.apellidos = apellidos;

		dao = new AlumnoDao();
		dao.updateAlumno(uno);
	}

	@DELETE
	@Path("/{id}")
	public void deleteAlumno(@PathParam("id") String id) {
		dao = new AlumnoDao();
		dao.deleteAlumno(Integer.parseInt(id));
	}

}
