package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agency.dao.UserDao;
import agency.dao.impl.DefaultUserDao;
import agency.models.UserData;

@WebServlet("/allUsers")
public class AllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	{
		userDao = DefaultUserDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserData> users = userDao.getAllUsers();
		request.setAttribute("users", users);

		UserData loggedInUser = new UserData();
		loggedInUser.setRole(1);
		request.setAttribute("loggedInUSer", loggedInUser);

		request.getRequestDispatcher("WEB-INF/views/allUsers.jsp").forward(request, response);
	}
}