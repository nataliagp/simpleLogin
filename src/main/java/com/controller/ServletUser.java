package main.java.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.daos.UserDAO;
import main.java.com.entity.User;

/**
 * Servlet implementation class ServletUser
 */
@WebServlet("/user")
public class ServletUser extends HttpServlet {
	
	private static final long serialVersionUID = 492954877322729803L;


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		
		if ("login".equals(tipo)) {
			this.login(request, response);
		} else if ("logout".equals(tipo)) {
			this.logout(request, response);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		String pass = request.getParameter("pass");

		UserDAO userDao = new UserDAO();
		User user = userDao.findUser(name, pass);

		if (user == null) {
			request.setAttribute("message", "Error nombre de usuario y/o clave");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("user", user);
			response.sendRedirect("main.jsp");
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("message", "Iniciar sesión");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
