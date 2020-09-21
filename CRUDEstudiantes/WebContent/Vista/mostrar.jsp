<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Administrar Alumnos</title>
	</head>
	<body>
		<h1>Administrar Alumnos</h1>
		<%
			String name=(String)session.getAttribute("name");
			if(name==null){	
			response.sendRedirect("servletUsuario?action=login");}
			else{System.out.println("Sesión actual: " +name);}
		%>
		<table>
			<tr>
				<th><a href="servletAlumno?action=nuevo">Registrar Alumno</a></th>			
			</tr>
			<tr>
				<th><a href="servletAlumno?action=mostrar">Mostrar Alumnos</a></th>
			</tr>
			<tr>
				<th><a href="servletUsuario?action=cerrarSesion">Cerrar Sesion</a></th>
			</tr>
		</table>
		<br>
		<form action="servletAlumno?action=buscarId" method="post">
			<table>
				<tr>
					<th>Buscar alumno por No. Control:</th>
					<td><input type="text" name="no_control"/></td>
					<td><input type="submit" value="Buscar" name="buscar"></td>	
				</tr>
			</table>
		</form>
		<br>
		<table>
			<tr>
			 <th>No. Control</th>
			 <th>Nombre</th>
			 <th>Curso</th>
			 <th>Semestre</th>
			 <th colspan=2>Acciones</th>
			</tr>
			<c:forEach var="alumno" items="${lista}">
				<tr>
					<td><c:out value="${alumnos.noControl}"/></td>
					<td><c:out value="${alumnos.nombre}"/></td>
					<td><c:out value="${alumnos.curso}"/></td>
					<td><c:out value="${alumnos.semestre}"/></td>
					<th><a href="servletAlumno?action=showeditar&no_control=<c:out value="${alumnos.noControl}" />">Editar</a></th>
					<th><a href="servletAlumno?action=eliminar&no_control=<c:out value="${alumnos.noControl}"/>">Eliminar</a> </th>				
				</tr>
			</c:forEach>
		</table>
	</body>
</html> 