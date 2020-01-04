package servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agency.dao.TourDao;
import agency.dao.impl.DefaultTourDao;


public class CreateTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String description = request.getParameter("desc");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int price = Integer.parseInt(request.getParameter("price"));
		
		TourDao tourDao = DefaultTourDao.getInstance();
		tourDao.createTourData(name, description, start, end, price);
	}
}