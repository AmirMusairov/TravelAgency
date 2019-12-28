package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TourDao;
import dao.impl.DefaultTourDao;

public class CreateTour extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String guide = request.getParameter("guide");
		String dateFrom = request.getParameter("from");
		String dateTo = request.getParameter("to");
		int price = Integer.parseInt(request.getParameter("price"));
		
		TourDao tourDao = DefaultTourDao.getTourDaoInstance();
		tourDao.createTour(name, guide, dateFrom, dateTo, price);
	}
}