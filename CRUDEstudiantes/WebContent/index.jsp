<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Bienvenido</title>
	</head>
	<body>
		<h1>Bienvenido</h1>
		<table>
			<tr>	
				<th><a href="servletUsuario?action=login">Iniciar sesión</a></th>  
			</tr>
			<tr>		
				<th><a href="servletUsuario?action=cerrarSesion">Cerrar sesión</a></th> 
			</tr>
			<tr>
				<th><a href="servletAlumno?action=mostrar">Listado de alumnos</a></th> 
			</tr> 
		</table>
	</body>
</html> 