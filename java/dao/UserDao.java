package dao;

import java.util.List;

import models.BookingData;
import models.CityData;
import models.HotelData;
import models.TourData;
import models.UserData;

public interface UserDao {
	
	UserData getUserById(int id);
	List<TourData> getToursForUser(int userId);
	List<HotelData> getHotelForUser(int userId);
	List<CityData> getCityForUser(int userId);
	List<BookingData> getBookingForUser(int userId);
}