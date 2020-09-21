package com.zaira.alumno.controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zaira.alumno.controlador.servletAlumno;
import com.zaira.alumno.dao.UsuarioDAO;
import com.zaira.alumno.modelo.Usuario;
import com.zaira.alumno.modelo.alumnos;

@WebServlet("/servletUsuario")
public class ServletUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDAO;
	servletAlumno servletAlumno;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			usuarioDAO = new UsuarioDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUsuario() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println("Hola Servlet Usuario..");
		String action = req.getParameter("action");
		System.out.println("Accion del servlet Usuario: "+ action);
		try {
			switch (action) {
			case "index":
				index(req, res);
				break;
			case "login":
				login(req, res);
				break;
			case "validarUsuario":
				validarUsuario(req, res);
				break;
			case "nuevoUsuario":
				nuevoUsuario(req, res);
				break;
			case "registrarUsuario":
				//System.out.println("entro");
				registrarUsuario(req, res);
				break;
			case "cerrarSesion":
				//System.out.println("entro");
				cerrarSesion(req, res);
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("Hola Servlet Usuario..");
		doGet(req, res);
	}

	private void index(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, res);
	}
	
	private void login(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= req.getRequestDispatcher("/Vista/login.jsp");
		dispatcher.forward(req, res);
	}

	private void validarUsuario(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		Usuario usuario = new Usuario(0, req.getParameter("usuario"), req.getParameter("password"));
		 if(usuarioDAO.validar(usuario)){
			 HttpSession session=req.getSession();  
		     session.setAttribute("name",req.getParameter("usuario"));  
		     String name=(String)session.getAttribute("name");
		     System.out.println("Sesion iniciada con el usuario: "+ name);
		     System.out.println("Hola, "+name+" bienvenido al listado de alumnos");  
		     RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/mostrar.jsp");
		     dispatcher.forward(req, res); 
		 }else{   
		 	System.out.println("Usuario o contraseña incorrecto");
	        RequestDispatcher dispatcher= req.getRequestDispatcher("/Vista/login.jsp");
			dispatcher.forward(req, res);  
		    }  
	}

	private void registrarUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		Usuario usuario = new Usuario(0, req.getParameter("usuario"), req.getParameter("password"));
		usuarioDAO.insertarUsuario(usuario);
		index(req, res);
	}

	private void nuevoUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/registrarUsuario.jsp");
		dispatcher.forward(req, res);
	}

	private void cerrarSesion(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		HttpSession session = req.getSession();
		System.out.println("Se cerrara la siguiente sesión: "+session.getAttribute("name"));
		//session.removeAttribute("name");
		session.invalidate();
		System.out.println("Se ha cerrado la sesión de manera exitosa");
		index(req, res);
	}
}