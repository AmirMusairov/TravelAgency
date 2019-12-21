package JDBC;

import java.util.List;

public interface UserDao {
	
	UserData getUserById(int id);
	List<TourData> getToursForUser(int userId);
	List<HotelData> getHotelForUser(int userId);
	List<CityData> getCityForUser(int userId);
	List<BookingData> getBookingForUser(int userId);
}