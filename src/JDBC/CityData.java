package JDBC;

public class CityData {
	
	private int id;
	private String cityName;
	private String countryName;
	private int hotelId;
	private int tourId;
	
	public int getId() {
		return id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	@Override
	public String toString() {
		return "CityData [id=" + id + ", cityName=" + cityName + ", countryName=" + countryName + ", hotelId=" + hotelId
				+ ", tourId=" + tourId + "]";
	}
}