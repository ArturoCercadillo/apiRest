package es.curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.curso.model.Profesor;
import es.curso.util.DbUtil;

public class ProfesoresLogica {
	private static Connection connection;

	public ProfesoresLogica() {
		connection = DbUtil.getConnection();
	}

	public ArrayList<Profesor> creaListaDeProfesores() throws ClassNotFoundException, SQLException {
		ArrayList<Profesor> listaProfesores = new ArrayList<Profesor>();
		try {
			// Creamos SQL
			String selectSQL = "select * from profesores order by id desc";
			// Creamos sentencia
			Statement statement = connection.createStatement();
			// ejecución sentencia
			ResultSet resultset = statement.executeQuery(selectSQL);
			// System.out.println(resultset);

			while (resultset.next()) {

				int id = resultset.getInt("id");// Integer.parseInt(resultset.getString("id"));
				String nombre = resultset.getString("nombre");
				String apellidos = resultset.getString("apellidos");
				int despacho = resultset.getInt("despacho");
				Profesor p = new Profesor(id, nombre, apellidos, despacho);

				listaProfesores.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaProfesores;

	}

	public void insertarProfesor(Profesor pNuevo) throws ClassNotFoundException, SQLException {
		try {
			Statement statement = connection.createStatement();

			String insertSQL = "insert into profesores (nombre,apellidos,despacho) values('" + pNuevo.getNombre()
					+ "','" + pNuevo.getApellidos() + "','" + pNuevo.getDespacho() + "')";

			statement.executeUpdate(insertSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarProfesor(int id_profesor) throws ClassNotFoundException, SQLException {
		try {
			Statement statement = connection.createStatement();

			String deleteSQL1 = "delete from universidad.asignaturas where profesor='" + id_profesor + "'";
			String deleteSQL2 = "delete from universidad.profesores where id='" + id_profesor + "'";

			statement.executeUpdate(deleteSQL1);
			statement.executeUpdate(deleteSQL2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Profesor obtenerProfesor(int idProfesor) throws ClassNotFoundException, SQLException {
		Profesor p = new Profesor();
		try {

			// Creamos SQL
			String selectSQL = "select * from profesores where id=" + idProfesor;
			// Creamos sentencia
			Statement statement = connection.createStatement();
			// ejecución sentencia
			ResultSet resultset = statement.executeQuery(selectSQL);

			// ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

			if (resultset.next()) {

				int id = resultset.getInt("id");
				String nombre = resultset.getString("nombre");
				String apellidos = resultset.getString("apellidos");
				int despacho = resultset.getInt("despacho");

				p.setId(id);
				p.setNombre(nombre);
				p.setApellidos(apellidos);
				p.setDespacho(despacho);

				// listaAlumnos.add(a);
				// System.out.println(resultset.getString("id"));
				// System.out.println(resultset.getString("dni"));
				// System.out.println(resultset.getString("nombre"));
				// System.out.println(resultset.getString("apellidos"));
				// System.out.println(resultset.getString("mes_nacimiento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public void actualizarProfesor(Profesor pNuevo) {
		try {
			Statement statement = connection.createStatement();

			String updateSQL = "update profesores set nombre='" + pNuevo.getNombre() + "', apellidos='"
					+ pNuevo.getApellidos() + "', despacho='" + pNuevo.getDespacho() + "' where id=" + pNuevo.getId()
					+ " ";

			statement.executeUpdate(updateSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
