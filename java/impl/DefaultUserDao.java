package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.UserDao;
import dbutils.DbHelper;
import models.BookingData;
import models.CityData;
import models.HotelData;
import models.TourData;
import models.UserData;

public class DefaultUserDao implements UserDao {

	private static final String SELECT_USER = "SELECT * FROM users WHERE id = ?";
	private static final String GET_TOURS_FOR_USER = "SELECT t.id_tour, t.tour_name, t.tour_price, t.hotel, t.city FROM tours t \r\n" + 
			"JOIN booking b ON t.id_tour = b.id_tour\r\n" + 
			"WHERE b.id_user = ?;";
	private static final String GET_HOTEL_FOR_USER = "SELECT h.id_hotel, h.hotel_name, h.hotel_stars, h.hotel_price FROM hotels h \r\n" + 
			"JOIN  tours t ON t.hotel = h.id_hotel\r\n" + 
			"WHERE t.city = ?;";
	private static final String GET_CITY_FOR_USER = "SELECT * FROM city \r\n" + 
			"WHERE id_country = ?;";
	private static final String GET_BOOKING_FOR_USER = "SELECT * FROM booking \r\n" + 
			"WHERE id_user = ?;";
			
	private static DefaultUserDao instance;
	private DbHelper dbHelper;
	
	private DefaultUserDao() {
		dbHelper = DbHelper.getInstance();
	}
	
	public synchronized static UserDao getInstance() {
		if (instance == null) {
			instance = new DefaultUserDao();
		}
		return instance;
	}
	
	@Override
	public UserData getUserById(int id) {
		try {
			UserData userData = null;
			
			try (Connection conn = dbHelper.getConnection(); 
					PreparedStatement statement = conn.prepareStatement(SELECT_USER);) {
				
				statement.setInt(1, id);
				try (ResultSet rs = statement.executeQuery();) {
					if (rs.next()) {
						userData = new UserData();
						userData.setIdUser(rs.getInt("id"));
						userData.setFirstName(rs.getString("first_name"));
						userData.setLastName(rs.getString("last_name"));
						userData.setTours(getToursForUser(id));
						userData.setHotels(getHotelForUser(id));				
						userData.setCity(getCityForUser(id));
						userData.setBooking(getBookingForUser(id));
					}
				}
			}
			return userData;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	@Override
	public List<TourData> getToursForUser(int userId) {
		List<TourData> tours = new ArrayList<TourData>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_TOURS_FOR_USER)) {
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setIdTour(rs.getInt("id_tour"));
				tourData.setTourName(rs.getString("tour_name"));
				tourData.setPrice(rs.getInt("tour_price"));
				tourData.setHotel(rs.getInt("hotel"));
				tourData.setCity(rs.getInt("city"));
				tours.add(tourData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

	@Override
	public List<HotelData> getHotelForUser(int userId) {
		List<HotelData> hotels = new ArrayList<HotelData>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_HOTEL_FOR_USER)) {
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HotelData hotelData = new HotelData();
				hotelData.setIdHotel(rs.getInt("id_hotel"));
				hotelData.setHotelName(rs.getString("hotel_name"));
				hotelData.setPrice(rs.getInt("hotel_price"));
				hotelData.setStars(rs.getInt("hotel_stars"));
				hotels.add(hotelData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return hotels;
	}	
	
	@Override
	public List<CityData> getCityForUser(int userId) {
		List<CityData> city = new ArrayList<CityData>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_CITY_FOR_USER)) {
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			CityData cityData = new CityData();
				cityData.setIdCity(rs.getInt("id_city"));
				cityData.setCityName(rs.getString("city_name"));
				cityData.setIdCountry(rs.getInt("id_country"));
				city.add(cityData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return city;
	}
	
	@Override
	public List<BookingData> getBookingForUser(int userId) {
		List<BookingData> booking = new ArrayList<BookingData>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_BOOKING_FOR_USER)) {
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			BookingData bookingData = new BookingData();
				bookingData.setIdBooking(rs.getInt("id_booking"));
				bookingData.setIdUser(rs.getInt("id_user"));
				bookingData.setIdTour(rs.getInt("id_tour"));
				booking.add(bookingData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return booking;
	}
}	