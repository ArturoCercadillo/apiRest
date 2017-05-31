package es.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.curso.model.Asignatura;
import es.curso.util.DbUtil;

public class AsignaturasLogica {

	private Connection conexion;

	public AsignaturasLogica() {
		conexion = DbUtil.getConnection();
	}

	public ArrayList<Asignatura> creaListaDeAsignaturas() {
		ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();

		try {
			// Creamos SQL
			String selectSQL = "SELECT asignaturas.id,descripcion,profesores.nombre,profesores.apellidos,profesores.despacho,profesores.id FROM universidad.asignaturas inner join profesores on asignaturas.profesor=profesores.id where asignaturas.descripcion is not null group by descripcion";
			// Creamos sentencia
			Statement statement = conexion.createStatement();
			// ejecución sentencia
			ResultSet resultset = statement.executeQuery(selectSQL);

			while (resultset.next()) {

				int id = resultset.getInt("asignaturas.id");// Integer.parseInt(resultset.getString("id"));
				String descripcion = resultset.getString("descripcion");
				int idProfesor = resultset.getInt("profesores.id");

				String nombreProfesor = resultset.getString("profesores.nombre");
				// int despacho = resultset.getInt("profesores.despacho");
				// int idProfesor = resultset.getInt("profesores.id");
				Asignatura a = new Asignatura(id, descripcion, idProfesor);

				listaAsignaturas.add(a);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaAsignaturas;

	}

	public void insertarAsignatura(Asignatura a) {
		try {
			String insertSQL = "insert into asignaturas(descripcion, profesor) values (?,?)";
			PreparedStatement pStmt = conexion.prepareStatement(insertSQL);
			pStmt.setString(1, a.getDescripcion());
			pStmt.setInt(2, a.getIdProfesor()); // Profesor
			int numeroDeFilasAfectadas = pStmt.executeUpdate();
			System.out.println("Filas afectadas: " + numeroDeFilasAfectadas);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void eliminarAsignatura(int idAsignatura) {
		try {
			Statement statement = conexion.createStatement();

			String deleteSQL1 = "delete from universidad.notas where asignatura='" + idAsignatura + "'";
			String deleteSQL2 = "delete from universidad.alumnos_has_asignaturas where asignatura='" + idAsignatura
					+ "'";
			String deleteSQL3 = "delete from universidad.asignaturas where id='" + idAsignatura + "'";

			statement.executeUpdate(deleteSQL1);
			statement.executeUpdate(deleteSQL2);
			statement.executeUpdate(deleteSQL3);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Asignatura obtenerAsignatura(int idAsignatura) {
		Asignatura a = new Asignatura();
		try {
			// Creamos SQL
			String selectSQL = "select * from asignaturas inner join profesores on asignaturas.profesor=profesores.id where asignaturas.id="
					+ idAsignatura;
			// Creamos sentencia
			Statement statement = conexion.createStatement();
			// ejecución sentencia
			ResultSet resultset = statement.executeQuery(selectSQL);

			if (resultset.next()) {

				int id = resultset.getInt("asignaturas.id");
				String descripcion = resultset.getString("asignaturas.descripcion");
				int idProfesor = resultset.getInt("asignaturas.profesor");
				String nombreProfe = resultset.getString("profesores.nombre");

				a = new Asignatura(id, descripcion, idProfesor);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	public void actualizarAsignatura(Asignatura aNueva)  {
		try {
			Statement statement = conexion.createStatement();
			String updateSQL = "update asignaturas set profesor='" + aNueva.getIdProfesor() + "' where id="
					+ aNueva.getId();

			statement.executeUpdate(updateSQL);			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
