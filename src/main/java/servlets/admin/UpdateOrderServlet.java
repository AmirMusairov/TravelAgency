package servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agency.dao.OrderDao;
import agency.dao.impl.DefaultOrderDao;

@WebServlet("/updateOrder")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		int orderId = Integer.parseInt(request.getParameter("orderId"));

		OrderDao orderDao = DefaultOrderDao.getInstance();
		orderDao.updateOrderData(orderId, userId);
	}
}