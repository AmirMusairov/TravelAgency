package models;

public class CityData {
	
	private int idCity;
	private String cityName;
	private int idCountry;
	
	public int getIdCity() {
		return idCity;
	}
	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(int idCountry) {
		idCountry = idCountry;
	}
	
	@Override
	public String toString() {
		return "CityData [idCity=" + idCity + ", cityName=" + cityName + ", IdCountry=" + idCountry + "]";
	}
}	