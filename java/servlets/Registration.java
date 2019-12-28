package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import impl.DefaultUserDao;
import models.UserData;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(" ").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserData userData = new UserData();
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("mail");
		String birthday = request.getParameter("birthday");
		
		userDao = DefaultUserDao.getUserDaoInstance();
		userDao.createUser(username, password, email, birthday);
		
		response.sendRedirect(getServletContext().getContextPath() + "/login ");
	}
}