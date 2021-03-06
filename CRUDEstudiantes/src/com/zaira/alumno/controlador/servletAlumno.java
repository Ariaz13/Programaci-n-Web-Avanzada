package com.zaira.alumno.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zaira.alumno.dao.estDao;
import com.zaira.alumno.modelo.alumnos;

@WebServlet("/servletAlumno")
public class servletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	estDao estdao;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			estdao = new estDao(jdbcURL, jdbcUsername, jdbcPassword);
		}catch (Exception e) {}
	}
	
	public servletAlumno() {}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet Alumno..");
		String action = request.getParameter("action");
		System.out.println("Accion del servlet Alumno:" + action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				//System.out.println("entro");
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "buscarNoControl":
				mostrarNoControl(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet Alumno..");
		doGet(request, response);
	}
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		alumnos alum = new alumnos(Integer.parseInt(request.getParameter("no_control")), request.getParameter("nombre"), request.getParameter("curso"), Integer.parseInt(request.getParameter("semestre")));
		estdao.insertar(alum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/mostrar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/registrar.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/mostrar.jsp");
		List<alumnos> listaAlum= estdao.listarAlumnos();
		request.setAttribute("lista", listaAlum);
		dispatcher.forward(request, response);
	}	
	
	private void mostrarNoControl(HttpServletRequest request, HttpServletResponse res) throws SQLException, ServletException, IOException{
		alumnos alum = estdao.obtenerPorNoControl(Integer.parseInt(request.getParameter("no_control")));
		List<alumnos> lista= new ArrayList<alumnos>();
		lista.add(alum);
		request.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/mostrar.jsp");
		dispatcher.forward(request, res);
	}
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		alumnos alum = estdao.obtenerPorNoControl(Integer.parseInt(request.getParameter("no_control")));
		request.setAttribute("alumno", alum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/editar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		alumnos alum = new alumnos(Integer.parseInt(request.getParameter("no_control")), request.getParameter("nombre"), request.getParameter("curso"), Integer.parseInt(request.getParameter("semestre")));
		estdao.actualizar(alum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/mostrar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		alumnos alum = estdao.obtenerPorNoControl(Integer.parseInt(request.getParameter("no_control")));
		estdao.eliminar(alum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Vista/mostrar.jsp");
		dispatcher.forward(request, response);
		
	}
}
