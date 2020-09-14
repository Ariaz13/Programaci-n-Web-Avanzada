<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registrar Alumno</title>
		<link rel="stylesheet" type="text/css" href="Vista/css/default.css">
	</head>
	<body>
		<h1>Registrar Alumno</h1>
		<form action="servletAlumno?action=registrar" method="post">
			<table>
				<tr>
					<th><a href="servletAlumno?action=mostrar" >Volver al menú</a> </td>
				</tr>
			</table>
			<table>
				<tr>
					<td>No. Control:</a></td>		
					<td><input type="text" name="no_control"/></td>	
				</tr>
				<tr>
					<td>Nombre:</a></td>		
					<td><input type="text" name="nombre"/></td>	
				</tr>
				<tr>
					<td>Curso:</a></td>		
					<td><input type="text" name="curso"/></td>	
				</tr>	
				<tr>
					<td>Semestre:</a></td>		
					<td><input type="text" name="semestre"/></td>	
				</tr>	
			</table>
			<br>
			<table>
				<tr>
				<td><input type="submit" value="Agregar" name="agregar"></td>	
				</tr>
			</table>
		</form>
	</body>
</html>