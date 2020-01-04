package agency.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import agency.dao.BookingDao;
import agency.dbutils.DbHelper;
import agency.models.BookingData;

public class DefaultBookingDao implements BookingDao {

//	private final static String CREATE_BOOKING = "INSERT INTO orders_hotels (order_id, hotel_id, checkin, checkout, price, nights) VALUES(?, ?, ?, ?, ?, ?)";
//	private final static String UPDATE_BOOKING = "UPDATE `travelAgency`.`orders_hotels` SET `order_id`= ?, `hotel_id`= ?, `checkin`= ?, `checkout`= ?, `price`= ?, `nights`= ? WHERE `booking_id`= ?;";
//	private final static String DELETE_BOOKING = "DELETE FROM orders_hotels WHERE booking_id = ?";
	private final static String SELECT_BOOKING_BY_ID = "SELECT * FROM orders_hotels WHERE booking_id = ?";
//	private final static String SELECT_BOOKING_BY_ORDER_ID = "SELECT * FROM orders_hotels WHERE order_id = ?";
//	private final static String SELECT_ALL_BOOKINGS = "SELECT * FROM orders_hotels";

	private static DefaultBookingDao instance;
	private DbHelper dbHelper;
	
	private DefaultBookingDao() {
		dbHelper = DbHelper.getInstance();
	}
	
	public synchronized static BookingDao getInstance() {
		if (instance == null) {
			instance = new DefaultBookingDao();
		}
		return instance;
	}
	
	@Override
	public BookingData getBookingById(int bookingId) {
		BookingData bookingData = null;
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_BOOKING_BY_ID);) {
			statement.setInt(1, bookingId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				bookingData = new BookingData(rs.getInt("booking_id"), rs.getInt("order_id"), rs.getInt("hotel_id"),
						rs.getDate("checkin"), rs.getDate("checkout"), rs.getInt("price"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookingData;
	}

	@Override
	public List<BookingData> getAllBookings() {
		return null;
	}

	@Override
	public List<BookingData> getBookingByOrderId(int orderId) {
		return null;
	}

	@Override
	public boolean deleteBookingData(int bookingId) {
		return false;
	}

	@Override
	public boolean updateBookingData(int bookingId, int orderId, int hotelId, String checkin, String checkout, int price) {
		return false;
	}

	@Override
	public boolean createBookingData(int orderId, int hotelId, String checkin, String checkout, int price) {
		return false;
	}

//	private static BookingData getBookingFromDb(ResultSet rs) throws SQLException {
//		return new BookingData(rs.getInt("booking_id"), rs.getInt("order_id"), rs.getInt("hotel_id"), rs.getDate("checkin"),
//				rs.getDate("checkout"), rs.getInt("price"));
//	}
}