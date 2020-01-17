package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agency.dao.UserDao;
import agency.dao.impl.DefaultUserDao;
import agency.models.UserData;


@WebServlet("/showUser")
public class ShowUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	private UserDao userDao;
	{
		userDao= DefaultUserDao.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData user = userDao.getUserById(Integer.parseInt(request.getParameter("user_id")));
		request.setAttribute("user", user);
		request.getRequestDispatcher("WEB-INF/views/showUser.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}