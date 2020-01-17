package agency.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agency.dao.HotelDao;
import agency.dbutils.DbHelper;
import agency.models.HotelData;

public class DefaultHotelDao implements HotelDao {

	private final static String CREATE_HOTEL = "INSERT INTO hotels (`name`, `address`, `price`, `city_id`, `city_name`)"
			+ "VALUES(?, ?, ?, (SELECT city_id FROM cities WHERE city_name = ?), ?)";
	private final static String DELETE_HOTEL = "DELETE FROM hotels WHERE hotel_id = ?";
	private final static String UPDATE_HOTEL = "UPDATE hotels SET  name = ?, address = ?, price = ?,  city_name= ? WHERE hotel_id =?;";
	private final static String SELECT_HOTEL_BY_ID = "SELECT * FROM hotels WHERE hotel_id = ?";
//	private final static String SELECT_HOTELS_BY_CITY = "SELECT * FROM hotels WHERE city_name = ?;";
	private final static String SELECT_ALL_HOTELS = "SELECT * FROM hotels";

	private static DefaultHotelDao instance;
	private DbHelper dbHelper;

	private DefaultHotelDao() {
		dbHelper = DbHelper.getInstance();
	}

	public synchronized static HotelDao getInstance() {
		if (instance == null) {
			instance = new DefaultHotelDao();
		}
		return instance;
	}

	@Override
	public HotelData getHotelById(int hotelId) {
		HotelData hotelData = null;
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_HOTEL_BY_ID);) {
			statement.setInt(1, hotelId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				hotelData = new HotelData(rs.getInt("hotel_id"), rs.getString("name"), rs.getString("address"),
						rs.getInt("price"), rs.getString("city_name"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hotelData;
	}

	@Override
	public List<HotelData> getAllHotels() {
		List<HotelData> hotelList = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ALL_HOTELS);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				hotelList.add(getHotelFromDb(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hotelList;
	}

	@Override
	public List<HotelData> getHotelsByCity(String cityName) {
		return null;
	}

	@Override
	public boolean deleteHotelData(int hotelId) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_HOTEL);) {
			statement.setInt(1, hotelId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean createHotelData(String name, String address, int price, String city) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(CREATE_HOTEL);) {
			statement.setString(1, name);
			statement.setString(2, address);
			statement.setInt(3, price);
			statement.setString(4, city);
			statement.setString(5, city);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean updateHotelData(int hotelId, String name, String address, int price, String city) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_HOTEL);) {

			statement.setString(1, name);
			statement.setString(2, address);
			statement.setInt(3, price);
			statement.setString(4, city);
			statement.setInt(5, hotelId);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	private static HotelData getHotelFromDb(ResultSet rs) throws SQLException {
		return new HotelData(rs.getInt("hotel_id"), rs.getString("name"), rs.getString("address"), rs.getInt("price"),
				rs.getString("city_name"));
	}
}