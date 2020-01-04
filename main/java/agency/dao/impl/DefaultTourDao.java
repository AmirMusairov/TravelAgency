package agency.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import agency.dao.OrderDao;
import agency.dao.TourDao;
import agency.dbutils.DbHelper;
import agency.models.TourData;
import agency.timezone.DateTimeConverter;

public class DefaultTourDao implements TourDao {

	private final static String CREATE_TOUR = "INSERT INTO tours (name, description, start, end, price) VALUES(?, ?, ?, ?, ?)";
	private final static String DELETE_TOUR = "DELETE FROM tours WHERE tour_id = ? LIMIT 1";
	private final static String UPDATE_TOUR = "UPDATE tours SET name = ? , description = ?, start = ?, end = ?, price = ? WHERE tour_id =?;";
	private final static String SELECT_TOUR_BY_ID = "SELECT * FROM tours WHERE tour_id = ?";
	private final static String SELECT_TOUR_BY_PERIOD = "SELECT * FROM tours WHERE start >= ? AND end <= ?";
	private final static String SELECT_ALL_TOURS = "SELECT * FROM tours";
	private final static String ORDER_TOUR = "INSERT INTO orders_tours (order_id, tour_id) VALUES(?, ?);";
//	private final static String DELETE_ORDERED_TOUR = "DELETE FROM orders_tours WHERE order_id =?";
	
	private static DefaultTourDao instance;
	private DbHelper dbHelper;
	
	private DefaultTourDao() {
		dbHelper = DbHelper.getInstance();
	}
	
	public synchronized static TourDao getInstance() {
		if (instance == null) {
			instance = new DefaultTourDao();
		}
		return instance;
	}
	
	@Override
	public TourData getTourById(int tourId) {
		TourData tourData = null;
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BY_ID);) {
			statement.setInt(1, tourId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				tourData = new TourData(rs.getInt("tour_id"), rs.getString("name"), rs.getString("description"),
						rs.getDate("start"), rs.getDate("end"), rs.getInt("price"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tourData;
	}

	@Override
	public List<TourData> getAllTours() {
		List<TourData> tourList = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ALL_TOURS);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				tourList.add(getTourFromDb(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tourList;
	}

	@Override
	public List<TourData> getToursByPeriod(String start, String end) { // Not sure that this work now...
		List<TourData> tourList = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BY_PERIOD);) {
			statement.setDate(1, DateTimeConverter.toSqlDate(start));
			statement.setDate(2, DateTimeConverter.toSqlDate(end));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				tourList.add(getTourFromDb(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tourList;
	}

	@Override
	public boolean createTourData(String name, String description, String start, String end, int price) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(CREATE_TOUR);) {
			statement.setString(1, name);
			statement.setString(2, description);
			statement.setDate(3, DateTimeConverter.toSqlDate(start));
			statement.setDate(4, DateTimeConverter.toSqlDate(end));
			statement.setInt(5, price);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateTourData(int tourId, String name, String description, String start, String end, int price) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_TOUR);) {
			statement.setString(1, name);
			statement.setString(2, description);
			statement.setDate(3, DateTimeConverter.toSqlDate(start));
			statement.setDate(4, DateTimeConverter.toSqlDate(end));
			statement.setInt(5, price);
			statement.setInt(6, tourId);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteTourData(int tourId) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_TOUR);) {
			statement.setInt(1, tourId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static TourData getTourFromDb(ResultSet rs) throws SQLException {
		return new TourData(rs.getInt("tour_id"), rs.getString("name"), rs.getString("description"), rs.getDate("start"),
				rs.getDate("end"), rs.getInt("price"));
	}

	@Override
	public boolean orderTourData(int orderId, int tourId) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(ORDER_TOUR);) {
			statement.setInt(1, orderId);
			statement.setInt(2, tourId);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteOrderedTourData(int orderId) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(ORDER_TOUR);) {
			statement.setInt(1, orderId);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}