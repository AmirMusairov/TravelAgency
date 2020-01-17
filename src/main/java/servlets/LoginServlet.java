package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import agency.dao.UserDao;
import agency.dao.impl.DefaultUserDao;
import agency.models.UserData;



@WebServlet(name= "LoginServlet", urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGGER_IN_USER_KEY = null;
	private UserDao userDao;
	{
		userDao = DefaultUserDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if(login == null || login.isEmpty() || password == null || password.isEmpty()) {
			response.sendRedirect(getServletContext().getContextPath()+"/login"); 
		} else {
			UserData user = userDao.getUserById(1); 
			if(user.getPassword().equals(password)) {
				
				HttpSession session = request.getSession();
				session.setAttribute(LOGGER_IN_USER_KEY,user);

				response.sendRedirect(getServletContext().getContextPath()+"/myaccount");
			}
			else {
				response.sendRedirect(getServletContext().getContextPath()+"/registerUser");
			}
		}
	
	}
}