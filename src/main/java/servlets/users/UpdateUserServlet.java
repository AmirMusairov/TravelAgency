package servlets.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agency.dao.UserDao;
import agency.dao.impl.DefaultUserDao;
import agency.models.UserData;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	{
		userDao= DefaultUserDao.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user",userDao.getUserById(Integer.parseInt(request.getParameter("userId"))));
		request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId=1;
		UserData userData=new UserData();
		userData.setUserId(Integer.parseInt(request.getParameter("userId")));
	
		userData.setUsername(request.getParameter("username"));
		userData.setEmail(request.getParameter("email"));
		userData.setPassword(request.getParameter("password"));
		userData.setRole(roleId);
		request.getRequestDispatcher("WEB-INF/views/myaccount.jsp").forward(request, response);
	}

}