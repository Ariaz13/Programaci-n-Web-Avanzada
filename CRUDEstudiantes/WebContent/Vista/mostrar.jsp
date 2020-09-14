<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Administrar Alumnos</title>
		<link rel="stylesheet" type="text/css" href="Vista/css/default.css">
	</head>
	<body>
		<h1>Administrar Alumnos</h1>
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
					<th><a href="servletAlumno?action=showeditar&id=<c:out value="${alumnos.noControl}" />">Editar</a></th>
					<th><a href="servletAlumno?action=eliminar&id=<c:out value="${alumnos.noControl}"/>">Eliminar</a> </th>				
				</tr>
			</c:forEach>
		</table>
	</body>
</html>