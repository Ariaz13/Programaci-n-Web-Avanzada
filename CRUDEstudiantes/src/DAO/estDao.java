package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.alumnos;
import Modelo.conexion;

public class estDao {
	private conexion con;
	private Connection connection;
	
	public estDao (String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException  {
		System.out.println(jdbcURL);
		con = new conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//Nuevo estudiante
	public boolean insertar(alumnos alum) throws SQLException{
		String sql = "INSERT INTO lista (no_control, nombre, curso, semestre) VALUES (?,?,?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, alum.getnoControl());
		statement.setString(2, alum.getnombre());
		statement.setString(3, alum.getcurso());
		statement.setString(4, alum.getsemestre());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
	
	//Mostrar estudiantes
	public List<alumnos> listarAlumnos() throws SQLException{
		List<alumnos> listaAlum = new ArrayList<alumnos>();
		String sql = "SELECT * FROM lista";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulset = statement.executeQuery(sql);
		
		while(resulset.next()) {
			int noControl = resulset.getInt("no_control");
			String nombre = resulset.getString("nombre");
			String curso = resulset.getString("curso");
			String semestre = resulset.getString("semestre");
			alumnos alum = new alumnos (noControl, nombre, curso, semestre);
			listaAlum.add(alum);
		}
		con.desconectar();
		return listaAlum;
	}
	
	//Buscar por No. Control
	public alumnos obtenerPorNoControl(int noControl) throws SQLException{
		alumnos alum = null;
		
		String sql = "SELECT * FROM lista WHERE no_control = ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, noControl);
		
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			alum = new alumnos (res.getInt("no_control"), res.getString("nombre"),
					res.getString("curso"), res.getString("semestre"));
		}
		res.close();
		con.desconectar();
		
		return alum;
	}
	
	//Actualizar 
	public boolean actualizar(alumnos alum) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE lista SET no_control=?, nombre=?, curso=?, semestre=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, alum.getnoControl());
		statement.setString(2, alum.getnombre());
		statement.setString(3, alum.getcurso());
		statement.setString(4, alum.getsemestre());
		
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//Eliminar
	public boolean eliminar(alumnos alum) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM articulos WHERE no_control=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, alum.getnoControl());
 
		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
 
		return rowEliminar;
	}
}
