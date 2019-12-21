package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultUserDao implements UserDao {

	private static final String SELECT_USER = "SELECT * FROM users WHERE id = ?";
	private static final String GET_TOURS_FOR_USER = "SELECT t.id, t.tour_name, t.tour_price, t.hotel_id, t.user_id FROM tours t\r\n" + 
			"JOIN booking b ON t.id = b.tour_id\r\n" + 
			"WHERE b.user_id = ?;";
	private static final String GET_HOTEL_FOR_USER = "SELECT h.id, h.hotel_name, h.hotel_stars, h.hotel_price, h.city_id FROM hotels h\r\n" + 
			"JOIN tours t ON h.id = t.hotel_id\r\n" + 
			"WHERE t.user_id = ?;";
	private static final String GET_CITY_FOR_USER = "SELECT * FROM city\r\n" + 
			"WHERE id = ?;";
	private static final String GET_BOOKING_FOR_USER = "SELECT * FROM booking \r\n" + 
			"WHERE user_id = ?;";
		
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
						userData.setId(rs.getInt("id"));
						userData.setFirstName(rs.getString("first_name"));
						int isBlocked = rs.getInt("is_blocked");
						userData.setTourId(rs.getInt("tour_id"));
						if (isBlocked == 1) {
							userData.setBlocked(true);
						}
						userData.setTours(getToursForUser(id));
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
				tourData.setId(rs.getInt("id"));
				tourData.setTourName(rs.getString("tour_name"));
				tourData.setPrice(rs.getInt("tour_price"));
				tourData.setHotelId(rs.getInt("hotel_id"));
				tourData.setUserId(rs.getInt("user_id"));
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
				hotelData.setId(rs.getInt("id"));
				hotelData.setHotelName(rs.getString("hotel_name"));
				hotelData.setPrice(rs.getInt("hotel_price"));
				hotelData.setStars(rs.getInt("hotel_stars"));
				hotelData.setCityId(rs.getInt("city_id"));
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
				cityData.setId(rs.getInt("id"));
				cityData.setCityName(rs.getString("city_name"));
				cityData.setCountryName(rs.getString("country_name"));
				cityData.setHotelId(rs.getInt("hotel_id"));
				cityData.setTourId(rs.getInt("tour_id"));
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
				bookingData.setId(rs.getInt("id"));
				bookingData.setUserId(rs.getInt("user_id"));
				bookingData.setTourId(rs.getInt("tour_id"));
				booking.add(bookingData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return booking;
	}
}	