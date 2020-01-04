package agency.dao;

import java.util.List;

import agency.models.BookingData;

public interface BookingDao {
	
	BookingData getBookingById(int bookingId);

	List<BookingData> getAllBookings();

	List<BookingData> getBookingByOrderId(int orderId);

	boolean deleteBookingData(int bookingId);

	boolean updateBookingData(int bookingId, int orderId, int hotelId, String checkin, String checkout, int price);

	boolean createBookingData(int orderId, int hotelId, String checkin, String checkout, int price);
}