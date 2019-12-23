package models;

import java.util.List;

public class UserData {
	
	private int id;
	private String firstName;
	private String lastName;
	private List<TourData> tours;
	private List<HotelData> hotels;
	private List<CityData> city;
	private List<BookingData> booking;
	
	public int getId() {
		return id;
	}
	public void setIdUser(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	@Override
	public String toString() {
		return "UserData [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", tours=" + tours
				+ ", hotels=" + hotels + ", booking=" + booking + "]";
	}
}