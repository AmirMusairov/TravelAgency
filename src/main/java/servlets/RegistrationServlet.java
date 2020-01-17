package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import agency.models.UserData;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/registerUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserData userData = new UserData();
		int roleId=1;
		userData.setUsername(request.getParameter("username"));
		userData.setEmail(request.getParameter("email"));
		userData.setRole(roleId);
		
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");

		if (password.equals(passwordCheck)) {
			userData.setPassword(passwordCheck);
			response.sendRedirect(getServletContext().getContextPath() + "/login");
		} else {
			response.sendRedirect(getServletContext().getContextPath() + "/error");
		}	
	}
}