package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agency.dao.UserDao;
import agency.dao.impl.DefaultUserDao;
//import agency.models.UserData;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		UserData userData = new UserData();
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("mail");
		String birthday = request.getParameter("birth");
		
		userDao = DefaultUserDao.getUserDaoInstance();
		userDao.createUserData(username, password, email, birthday, 2);
		
		response.sendRedirect(getServletContext().getContextPath() + "/login ");
	}

}