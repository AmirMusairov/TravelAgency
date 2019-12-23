package models;

public class TourData {
	
	private int idTour;
	private String tourName;
	private int price;
	private int hotel;
	private int city;
	
	public int getIdTour() {
		return idTour;
	}
	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getHotel() {
		return hotel;
	}
	public void setHotel(int hotel) {
		this.hotel = hotel;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "TourData [idTour=" + idTour + ", tourName=" + tourName + ", price=" + price + ", hotel=" + hotel
				+ ", city=" + city + "]";
	}
}