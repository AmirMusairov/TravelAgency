package models;

public class BookingData {
	
	private int idBooking;
	private int idUser;
	private int idTour;
	
	public int getIdBooking() {
		return idBooking;
	}
	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdTour() {
		return idTour;
	}
	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}
	
	@Override
	public String toString() {
		return "BookingData [idBooking=" + idBooking + ", idUser=" + idUser + ", idTour=" + idTour + "]";
	}
}