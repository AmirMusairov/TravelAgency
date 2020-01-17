package agency.models;

import java.util.Date;

public class BookingData {

	private int bookingId;
	private int orderId;
	private int hotelId;
	private Date checkin;
	private Date checkout;
	private int price;

	public BookingData(int bookingId, int orderId, int hotelId, Date checkin, Date checkout, int price) {
		this.bookingId = bookingId;
		this.orderId = orderId;
		this.hotelId = hotelId;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", orderId=" + orderId + ", hotelId=" + hotelId + ", checkin="
				+ checkin + ", checkout=" + checkout + ", price=" + price + "]";
	}
}