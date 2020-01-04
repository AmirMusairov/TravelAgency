package servlets.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agency.dao.UserDao;
import agency.dao.impl.DefaultUserDao;

public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		String email = request.getParameter("mail");
		String birthday = request.getParameter("birth");
		int role = Integer.parseInt(request.getParameter("role"));
		
		UserDao userDao = DefaultUserDao.getUserDaoInstance();
		userDao.updateUserData(userId, username, password, email, birthday, role);
	}

}