package apiRest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.curso.dao.LoginDAo;
import es.curso.model.Usuario;

@Path("/login")
public class Login {
	private Usuario usuario;
	private LoginDAo dao;
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario login(@FormParam("usuario") String user, @FormParam("password") String password) {
		
		dao = new LoginDAo();
		usuario = dao.login(user, password);
		
		return usuario;
	}
}

