package apiRest;
import java.sql.SQLException;
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

import es.curso.dao.ProfesoresLogica;
import es.curso.model.Profesor;

@Path("/profesores")
public class profesores {

	private ProfesoresLogica dao;
	private Profesor Profesor;
	private List<Profesor> profesores;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profesor getProfesor(@PathParam("id") String id)
			throws NumberFormatException, ClassNotFoundException, SQLException {
		System.out.println(id);
		dao = new ProfesoresLogica();
		Profesor = dao.obtenerProfesor(Integer.parseInt(id));

		return Profesor;
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profesor> getProfesor() throws ClassNotFoundException, SQLException {
		dao = new ProfesoresLogica();
		profesores = dao.creaListaDeProfesores();

		return profesores;

	}

	@POST
	@Path("/")
	public void addProfesor(@FormParam("nombre") String nombre, @FormParam("apellidos") String apellidos,
			@FormParam("despacho") String despacho) throws ClassNotFoundException, SQLException {

		Profesor uno = new Profesor();
		uno.nombre = nombre;
		uno.despacho = Integer.parseInt(despacho);
		uno.apellidos = apellidos;

		dao = new ProfesoresLogica();
		dao.insertarProfesor(uno);
		System.out.println("añadido: " + uno.toString());
	}

	@PUT
	@Path("/")
	public void editProfesor(@FormParam("id") String id, @FormParam("nombre") String nombre,
			@FormParam("apellidos") String apellidos, @FormParam("despacho") String despacho) {

		Profesor uno = new Profesor();
		uno.id = Integer.parseInt(id);
		uno.despacho = Integer.parseInt(despacho);
		uno.nombre = nombre;
		uno.apellidos = apellidos;
		dao = new ProfesoresLogica();
		dao.actualizarProfesor(uno);
	}

	@DELETE
	@Path("/{id}")
	public void deleteProfesor(@PathParam("id") String id)
			throws NumberFormatException, ClassNotFoundException, SQLException {
		dao = new ProfesoresLogica();
		dao.eliminarProfesor(Integer.parseInt(id));
	}

}
