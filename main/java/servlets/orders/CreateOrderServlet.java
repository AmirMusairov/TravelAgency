package servlets.orders;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agency.dao.OrderDao;
import agency.dao.impl.DefaultOrderDao;

public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		OrderDao orderDao = DefaultOrderDao.getInstance();
		orderDao.createOrderData(userId);
	}

}