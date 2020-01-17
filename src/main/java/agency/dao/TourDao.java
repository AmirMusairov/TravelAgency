package agency.dao;

import java.util.List;

import agency.models.TourData;

public interface TourDao {

	TourData getTourById(int tourId);

	List<TourData> getAllTours();

	List<TourData> getToursByPeriod(String start, String end);

	boolean createTourData(String name, String description, String start, String end, int price);

	boolean updateTourData(int tourId, String name, String description, String start, String end, int price);

	boolean deleteTourData(int tourId);

	boolean orderTourData(int orderId, int tourId);

	boolean deleteOrderedTourData(int orderId);
}