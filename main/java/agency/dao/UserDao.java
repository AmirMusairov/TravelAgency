package agency.dao;

import java.util.List;

import agency.models.UserData;

public interface UserDao {

	UserData getUserById(int userId);

	boolean createUserData(String username, String password, String email, String birthday, int roleId);

	boolean deleteUserData(int userId);

	boolean updateUserData(int userId, String username, String password, String email, String birthday, int roleId);

	List<UserData> getAllUsers();
	
	UserData getUserByEmail(String email);
	
	UserData getUserByOrderId(int orderId);
}