package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import dao.UserDao;
import impl.DefaultUserDao;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = DefaultUserDao.getInstance();
		PrintWriter writer = response.getWriter();
		int userId = Integer.parseInt(request.getParameter("userId"));
		try {
			writer.println(userDao.getUserById(userId));
		} finally {
			writer.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}