package JDBC;

public class HotelData {
	
	private int id;
	private String hotelName;
	private int price;
	private int stars;
	private int cityId;
	
	public int getId() {
		return id;
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
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "HotelData [id=" + id + ", hotelName=" + hotelName + ", price=" + price + ", stars=" + stars
				+ ", cityId=" + cityId + "]";
	}
}