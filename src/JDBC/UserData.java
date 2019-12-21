package JDBC;

import java.util.List;

public class UserData {
	
	private int id;
	private String firstName;
	private boolean isBlocked;
	private int tourId;
	private List<TourData> tours;
	private List<HotelData> hotels;
	private List<CityData> city;
	private List<BookingData> booking;

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<TourData> getTours() {
		return tours;
	}

	public void setTours(List<TourData> tours) {
		this.tours = tours;
	}

	public List<HotelData> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelData> hotels) {
		this.hotels = hotels;
	}

	public List<CityData> getCity() {
		return city;
	}

	public void setCity(List<CityData> city) {
		this.city = city;
	}
	
	public List<BookingData> getBooking() {
		return booking;
	}

	public void setBooking(List<BookingData> booking) {
		this.booking = booking;
	}
	
	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", firstName=" + firstName + ", isBlocked=" + isBlocked + ", tourId=" + tourId + ", tours=" + tours + ", hotel=" + hotels 
				+ ", city=" + city + ", booking=" + booking + "]";
	}
}