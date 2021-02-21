<% 
	if (session.getAttribute("user") == null) {
		request.setAttribute("message", "Debe autenticarse para ingresar al sistema");
		pageContext.forward("index.jsp");
	}
%>