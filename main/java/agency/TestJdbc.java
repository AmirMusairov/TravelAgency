package agency;

//import java.util.List;

//import agency.dao.HotelDao;
//import agency.dao.OrderDao;
//import agency.dao.TourDao;
import agency.dao.UserDao;
//import agency.dao.impl.DefaultHotelDao;
//import agency.dao.impl.DefaultOrderDao;
//import agency.dao.impl.DefaultTourDao;
import agency.dao.impl.DefaultUserDao;
//import agency.models.OrderData;
//import agency.models.TourData;
//import agency.models.UserData;

public class TestJdbc {
	public static void main(String[] args) {

		UserDao userDao =  DefaultUserDao.getUserDaoInstance();
//		UserData userData = userDao.getUserById(2);
//		List<UserData> userData2 = userDao.getAllUsers();
//		 userDao.createUserData("Seriy23", "pisya", "toha@lds.net", "1990-03-02", 0);
		 userDao.createUserData("Tomas", "Gigila", "mirkos@lds.net", "12/02/1999", 2);
//		userDao.updateUserData(8, "toma2", "ppx", "tmgh", "08/12/2000", 0);
//		 userDao.deleteUserData(8);
//		UserData userData2 = userDao.getUserByEmail("toha@lds.net");
//		System.out.println(userData2);
//
//		System.out.println(userData2);
//	TourDao tourDao = DefaultTourDao.getInstance();
//
//		 List<TourData> listTours = tourDao.getAllTours();
//		tourDao.createTourData("Tour4", "spanish-italy", "12/12/1929", "08/12/2000", 452);
//		tourDao.updateTourData(3, "Tour3updated", "spanish-italy", "11/11/1111", "12/12/1212", 454);
//		 tourDao.deleteTourData(2);
//		 tourDao.orderTourData(2, 1);
//
//		 TourData tourData = tourDao.getTourById(1);
//		 System.out.println(listTours);
//
//		HotelDao hotelDao = new DefaultHotelDao();
//		hotelDao.updateHotelData(5, "d", "AD", 33, "kiev");
//		hotelDao.createHotelData("Hote1", "pushi", 43, "kiev");
//		OrderDao orderDao = new DefaultOrderDao();
//		orderDao.createOrderData(5);
//		orderDao.deleteOrderData(1);
//		orderDao.updateOrderData(2, 3);
//
//		
//		OrderDao OrderDao = DefaultOrderDao.getInstance();
//		orderDao.getOrderById(2);
//		System.out.println(orderDao.getOrderById(2));
//		OrderData orderData = new OrderData(null);	
	}
}