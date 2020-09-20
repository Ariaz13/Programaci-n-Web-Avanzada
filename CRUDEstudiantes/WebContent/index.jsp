<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="Vista/css/default.css">
	</head>
	<body>
		<h1>Login</h1>
		<h1>Login</h1>
		<form action="servletUsuario?action=validarUsuario" method="post">
			Usuario:
			<% 
				Cookie[] cookies = request.getCookies();
				String valor = "";
				for(Cookie c:cookies){
					if(c.getName().equals("usuario")){
						valor = c.getValue();
					} else {System.out.println("No encontrado	");}
				}
			%>
			<input type="text" name="usuario" value = "<%=valor%>"/><br/><br/>
			Contraseña:<input type="password" name="password"/><br/><br/>  
			<input name="ckbox" type="checkbox" checked="checked"> Recordar mis datos</><br> 
			<input type="submit" value="login"/>
		</form> 
		<table>
			<tr>		
				<th><a href="servletUsuario?action=nuevoUsuario">Registrar nuevo usuario</a></th>
			</tr>
		</table>
	</body>
</html> 