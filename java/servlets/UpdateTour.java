package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TourDao;
import impl.DefaultTourDao;

public class UpdateTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TourDao tourDao = DefaultTourDao.getTourDaoInstance();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int tourId = Integer.parseInt(request.getParameter("tourId"));
		String name = request.getParameter("name");
		String guide = request.getParameter("guide");
		String dateFrom = request.getParameter("from");
		String dateTo = request.getParameter("to");
		int price = Integer.parseInt(request.getParameter("price"));

		tourDao.updateTour(tourId, name, guide, dateFrom, dateTo, price);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tourId = Integer.parseInt(request.getParameter("tourId"));
		boolean delete = "true".equals(request.getParameter("del"));
		if (delete) {
			tourDao.deleteTour(tourId);
		}
	}
}