package es.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.curso.model.Usuario;
import es.curso.util.DbUtil;

public class LoginDAo {
	private Connection connection;

	public LoginDAo() {
		connection = DbUtil.getConnection();
	}
	
	public Usuario login(String usuario, String password){

		Usuario user = new Usuario();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from usuarios where usuario=? and password=?");
			preparedStatement.setNString(1, usuario);
			preparedStatement.setNString(2, password);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsuario(rs.getString("usuario"));
				user.setPassword(rs.getString("password"));
				user.setAlumno(rs.getInt("alumno"));
				user.setProfesor(rs.getInt("profesor"));
				user.setEstado(rs.getInt("estado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
		
}
