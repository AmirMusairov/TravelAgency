package agency.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agency.dao.UserDao;
import agency.dbutils.DbHelper;
import agency.models.UserData;
import agency.timezone.DateTimeConverter;

public class DefaultUserDao implements UserDao {

	private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
	private static final String CREATE_USER = "INSERT INTO users(username, password, email, birthday , role_id) VALUES(?, ?, ?, ?, ?)";
	private static final String DELETE_USER = "DELETE FROM users WHERE user_id = ?";
	private static final String UPDATE_USER = "UPDATE users SET username = ?, password = ?, email = ?, birthday = ?, role_id = ? WHERE user_id = ?";
	private static final String SELECT_ALL_USER = "SELECT * FROM users";
	public static final String SELECT_USER_BY_EMAIL_PREPARED = "SELECT * FROM users WHERE email = ?";
	private final static String SELECT_USER_BY_ORDER_ID = "SELECT u.user_id, u.username, u.password, u.email, u.birthday, u.role_id FROM orders o INNER JOIN users u WHERE o.user_id = ?;";

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
	public UserData getUserById(int userId) {
		UserData userData = null;
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_ID);) {
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				userData = new UserData(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getDate("birthday"), rs.getInt("role_id"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userData;
	}

	public static synchronized DefaultUserDao getUserDaoInstance() {
		if (instance == null) {
			instance = new DefaultUserDao();
		}
		return instance;
	}

	@Override
	public boolean createUserData(String username, String password, String email, String birthday, int roleId) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(CREATE_USER);) {

			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setDate(4, DateTimeConverter.toSqlDate(birthday));
			statement.setInt(5, roleId);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean deleteUserData(int userId) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_USER);) {

			statement.setInt(1, userId);
			statement.executeUpdate();
			// return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUserData(int userId, String username, String password, String email, String birthday,
			int roleId) {
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_USER);) {

			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setDate(4, DateTimeConverter.toSqlDate(birthday));
			statement.setInt(5, roleId);
			statement.setInt(6, userId);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<UserData> getAllUsers() {
		List<UserData> userList = new ArrayList<>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ALL_USER);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				userList.add(getUserFromDb(rs));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	private static UserData getUserFromDb(ResultSet rs) throws SQLException {
		UserData user = new UserData(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
				rs.getString("email"), rs.getDate("birthday"), rs.getInt("role_id"));
		return user;
	}

	@Override
	public UserData getUserByEmail(String email) {
		UserData userData = null;
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_EMAIL_PREPARED);) {
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				userData = new UserData(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getDate("birthday"), rs.getInt("role_id"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userData;
	}

	@Override
	public UserData getUserByOrderId(int orderId) {
		UserData userData = null;
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_ORDER_ID);) {
			statement.setInt(1, orderId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				userData = new UserData(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getDate("birthday"), rs.getInt("role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userData;
	}
}