package models;

public class HotelData {
	
	private int idHotel;
	private String hotelName;
	private int price;
	private int stars;
	
	public int getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	@Override
	public String toString() {
		return "HotelData [idHotel=" + idHotel + ", hotelName=" + hotelName + ", price=" + price + ", stars=" + stars
				+ "]";
	}
}	