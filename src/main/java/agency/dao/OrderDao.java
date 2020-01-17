package agency.dao;

import java.util.List;

import agency.models.OrderData;

public interface OrderDao {

	OrderData getOrderById(int orderId);

	List<OrderData> getAllOrders();

	List<OrderData> getOrdersByUserId(int userId);

	boolean deleteOrderData(int orderId);

	int createOrderData(int userId);

	public boolean updateOrderData(int orderId, int userId);
}