package agency.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import agency.dao.OrderDao;
import agency.dbutils.DbHelper;
import agency.models.OrderData;

public class DefaultOrderDao implements OrderDao {

	private final static String CREATE_ORDER = "INSERT INTO orders (user_id) VALUES (?);";
	private final static String DELETE_ORDER = "DELETE FROM orders WHERE order_id = ?";
	private final static String SELECT_ORDER_BY_ID = "SELECT o.order_id, u.user_id, u.email AS user_email, t.tour_id, t.`name` AS tour_name, t.price AS tour_price, "
			+ "h.hotel_id, oh.price AS hotel_price "
			+ "FROM orders o INNER JOIN users u ON o.user_id = u.user_id LEFT JOIN orders_tours ot ON o.order_id = ot.order_id "
			+ "LEFT JOIN orders_hotels oh ON o.order_id = oh.order_id "
			+ "LEFT JOIN hotels h ON h.hotel_id = oh.hotel_id WHERE o.order_id = ? GROUP BY o.order_id";
	private final static String UPDATE_ORDER = "UPDATE orders SET  user_id = ? WHERE order_id =?;";

	private static DefaultOrderDao instance;
	private DbHelper dbHelper;

	private DefaultOrderDao() {
		dbHelper = DbHelper.getInstance();
	}

	public synchronized static OrderDao getInstance() {
		if (instance == null) {
			instance = new DefaultOrderDao();
		}
		return instance;
	}

	@Override
	public OrderData getOrderById(int orderId) {
		OrderData orderData = null;
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ORDER_BY_ID);) {
			statement.setInt(1, orderId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				orderData = getOrderFromDb(rs);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderData;
	}

	@Override
	public List<OrderData> getAllOrders() {
		return null;
	}

	@Override
	public List<OrderData> getOrdersByUserId(int userId) {
		return null;
	}

	@Override
	public boolean deleteOrderData(int orderId) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_ORDER);) {
			statement.setInt(1, orderId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int createOrderData(int userId) {

		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(CREATE_ORDER);) {
			statement.setInt(1, userId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public boolean updateOrderData(int orderId, int userId) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_ORDER);) {

			statement.setInt(1, userId);
			statement.setInt(2, orderId);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	private static OrderData getOrderFromDb(ResultSet rs) throws SQLException {
		int userId = rs.getInt("user_id");
		String userEmail = rs.getString("user_email");
		int orderId = rs.getInt("order_id");
		int tourId = rs.getInt("tour_id");
		String tourName = rs.getString("tour_name");
		int tourPrice = rs.getInt("tour_price");
		int hotelId = rs.getInt("hotel_id");
		int hotelPrice = rs.getInt("hotel_price");

		return new OrderData(new OrderData.OrderBuilder(userId, orderId, userEmail).setTourId(tourId)
				.setTourName(tourName).setTourPrice(tourPrice).setHotelId(hotelId).setHotelPrice(hotelPrice));
	}
}