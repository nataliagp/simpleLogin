<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio de Sesión</title>
</head>
<body>
	<form action="user" method="post">
		<input type="hidden" name="tipo" value="login" />
		<table>
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>Clave</td>
				<td><input type="password" name="pass" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Iniciar sesión" /></td>
			</tr>
		</table>
		<div>
			<p>
				<%
				String result = (String) request.getAttribute("message");
				String message = "";
				if (result != null) {
					message = result;
				}
				%>
				<%=message%>
			</p>
		</div>
	</form>
</body>
</html>