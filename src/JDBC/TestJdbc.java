package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestJdbc {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		UserDao userDao = DefaultUserDao.getInstance();
		UserData user = userDao.getUserById(1);
		System.out.println(user);
		
		List<TourData> toursForUser = userDao.getToursForUser(1);
		System.out.println(toursForUser);
		
		List<HotelData> hotelForUser = userDao.getHotelForUser(1);
		System.out.println(hotelForUser);
		
		List<CityData> cityForUser = userDao.getCityForUser(1);
		System.out.println(cityForUser);
		
		List<BookingData> bookingForUser = userDao.getBookingForUser(1);
		System.out.println(bookingForUser);
	}
}