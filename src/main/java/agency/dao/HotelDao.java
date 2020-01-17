package agency.dao;

import java.util.List;

import agency.models.HotelData;

public interface HotelDao {

	HotelData getHotelById(int hotelId);

	List<HotelData> getAllHotels();

	List<HotelData> getHotelsByCity(String cityName);

	boolean deleteHotelData(int hotelId);

	boolean createHotelData(String name, String address, int price, String city);

	boolean updateHotelData(int hotelId, String name, String address, int price, String city);
}