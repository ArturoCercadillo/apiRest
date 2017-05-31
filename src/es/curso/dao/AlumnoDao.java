package es.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.curso.model.Alumno;
import es.curso.model.Asignatura;
import es.curso.util.DbUtil;

public class AlumnoDao {

	private Connection connection;

	public AlumnoDao() {
		connection = DbUtil.getConnection();
	}

	public void addAlumno(Alumno alumno) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Alumnos(dni,nombre,apellidos,mes_nacimiento) values (?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, alumno.getDni());
			preparedStatement.setString(2, alumno.getNombre());
			preparedStatement.setString(3, alumno.getApellidos());
			preparedStatement.setInt(4, alumno.getMes());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAlumno(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from alumnos where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAlumno(Alumno alumno) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update alumnos set dni=?, nombre=?, apellidos=?, mes_nacimiento=? where id=?");
			// Parameters start with 1
			preparedStatement.setString(1, alumno.getDni());
			preparedStatement.setString(2, alumno.getNombre());
			preparedStatement.setString(3, alumno.getApellidos());
			preparedStatement.setInt(4, alumno.getMes());
			preparedStatement.setInt(5, alumno.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Alumno> getAllAlumnos() {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from alumnos");
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellidos(rs.getString("apellidos"));
				alumno.setMes(rs.getInt("mes_nacimiento"));
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alumnos;
	}

	public Alumno getAlumnoById(int id) {
		Alumno alumno = new Alumno();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from alumnos where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellidos(rs.getString("apellidos"));
				alumno.setMes(rs.getInt("mes_nacimiento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alumno;
	}

	public ArrayList<Asignatura> creaListaDeAsignaturasDeAlumno(int idAlumno) {

		ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT asignaturas.id,descripcion,asignaturas.profesor FROM universidad.alumnos inner join alumnos_has_asignaturas on alumnos.id=alumnos_has_asignaturas.alumno inner join asignaturas on alumnos_has_asignaturas.asignatura=asignaturas.id where alumnos.id=?");
			preparedStatement.setInt(1, idAlumno);
			ResultSet rs = preparedStatement.executeQuery();
			

			while (rs.next()) {
				Asignatura asignatura = new Asignatura();
				asignatura.setId(rs.getInt("id"));
				asignatura.setDescripcion(rs.getString("descripcion"));
				asignatura.setIdProfesor(rs.getInt("profesor"));

				listaAsignaturas.add(asignatura);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaAsignaturas;

	}
}