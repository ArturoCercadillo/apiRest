package apiRest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.curso.dao.AsignaturasLogica;
import es.curso.model.Asignatura;

@Path("/asignaturas")
public class Asignaturas {

	private AsignaturasLogica asignaturaDao;
	private Asignatura asignatura;
	private List<Asignatura> asignaturas;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Asignatura getAsignatura(@PathParam("id") String id) {
		System.out.println(id);
		asignaturaDao = new AsignaturasLogica();
		asignatura = asignaturaDao.obtenerAsignatura(Integer.parseInt(id));

		return asignatura;
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Asignatura> getAsignaturas() {
		asignaturaDao = new AsignaturasLogica();
		asignaturas = asignaturaDao.creaListaDeAsignaturas();

		return asignaturas;

	}

	@POST
	@Path("/")
	public void addAsignatura(@FormParam("descripcion") String descripcion, @FormParam("profesor") String idProfesor) {

		Asignatura una = new Asignatura();
		una.descripcion = descripcion;
		una.idProfesor = Integer.parseInt(idProfesor);

		asignaturaDao = new AsignaturasLogica();
		asignaturaDao.insertarAsignatura(una);
		System.out.println("añadido: " + una.toString());
	}

	@PUT
	@Path("/")
	public void editAsignatura(@FormParam("descripcion") String descripcion, @FormParam("profesor") String idProfesor) {

		Asignatura una = new Asignatura();
		una.descripcion = descripcion;
		una.idProfesor = Integer.parseInt(idProfesor);

		asignaturaDao = new AsignaturasLogica();
		asignaturaDao.actualizarAsignatura(una);
	}

	@DELETE
	@Path("/{id}")
	public void deleteAsignatura(@PathParam("id") String id) {
		asignaturaDao = new AsignaturasLogica();
		asignaturaDao.eliminarAsignatura(Integer.parseInt(id));
	}

}
