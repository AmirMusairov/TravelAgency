package JDBC;

public class TourData {
	
	private int id;
	private String tourName;
	private int price;
	private int hotelId;
	private int userId;
	
	public int getId() {
		return id;
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

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TourData [id=" + id + ", tourName=" + tourName + ", price=" + price + ", hotelId=" + hotelId
				+ ", userId=" + userId + "]";
	}
	
	

}