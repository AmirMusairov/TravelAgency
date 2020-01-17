package agency.models;

public class OrderData {

	private int userId;
	private int orderId;
	private String userEmail;
	private int tourId;
	private String tourName;
	private int tourPrice;
	private int hotelId;
	private int hotelPrice;

	public OrderData(OrderBuilder builder) {
		this.userId = builder.userId;
		this.orderId = builder.orderId;
		this.userEmail = builder.userEmail;
		this.tourId = builder.tourId;
		this.tourName = builder.tourName;
		this.tourPrice = builder.tourPrice;
		this.hotelId = builder.hotelId;
		this.hotelPrice = builder.hotelPrice;

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public int getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(int tourPrice) {
		this.tourPrice = tourPrice;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	@Override
	public String toString() {
		return "OrderData [userId=" + userId + ", orderId=" + orderId + ", userEmail=" + userEmail + ", tourId="
				+ tourId + ", tourName=" + tourName + ", tourPrice=" + tourPrice + ", hotelId=" + hotelId
				+ ", hotelPrice=" + hotelPrice + "]";
	}

	public static class OrderBuilder {

		private int userId;
		private int orderId;
		private String userEmail;
		private int tourId;
		private String tourName;
		private int tourPrice;
		private int hotelId;
		private int hotelPrice;

		public OrderBuilder(int userId, int orderId, String userEmail) {
			this.userId = userId;
			this.orderId = orderId;
			this.userEmail = userEmail;
		}

		public OrderBuilder setHotelPrice(int hotelPrice) {
			this.hotelPrice = hotelPrice;
			return this;
		}

		public OrderBuilder setHotelId(int hotelId) {
			this.hotelId = hotelId;
			return this;
		}

		public OrderBuilder setTourPrice(int tourPrice) {
			this.tourPrice = tourPrice;
			return this;
		}

		public OrderBuilder setTourName(String tourName) {
			this.tourName = tourName;
			return this;
		}

		public OrderBuilder setTourId(int tourId) {
			this.tourId = tourId;
			return this;
		}
	}
}
