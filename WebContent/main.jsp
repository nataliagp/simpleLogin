<jsp:include page="validate.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Principal</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	Bienvenido/a ${sessionScope.user.fullName}
</body>
</html>