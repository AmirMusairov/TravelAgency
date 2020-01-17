package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import agency.models.UserData;


@WebServlet("/myAccount")
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserData loggedUser = (UserData) request.getSession().getAttribute("loggerInUser");
		String loggedUserName = loggedUser.getUsername();
		String loggedUserEmail = loggedUser.getEmail();
		request.setAttribute("loggedUserName", loggedUserName);
		request.setAttribute("loggedUserEmail", loggedUserEmail);
		request.getRequestDispatcher("WEB-INF/views/myaccount.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
