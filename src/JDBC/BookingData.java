package JDBC;

public class BookingData {
	
	private int id;
	private int userId;
	private int tourId;
	
	public int getId() {
		return id;
	}
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "BookingData [id=" + id + ", userId=" + userId + ", tourId=" + tourId + "]";
	}
}