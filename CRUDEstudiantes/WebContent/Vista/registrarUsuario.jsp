<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registrar Usuario</title>
	</head>
	<body>
		<h1>Registrar Usuario</h1>
		<form action="servletUsuario?action=registrarUsuario" method="post">
			<table>
				<tr>
					<th><a href="servletUsuario?action=login" >Volver al login</a> </td>
				</tr>
			</table>
			<table>
				<tr>
					<td>Usuario:</a></td>		
					<td><input type="text" name="usuario"/></td>	
				</tr>
				<tr>
					<td>Contraseña:</a></td>		
					<td><input type="text" name="password"/></td>	
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