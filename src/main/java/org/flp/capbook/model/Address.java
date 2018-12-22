package org.flp.capbook.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {
  
	@Id
	@GeneratedValue
	private Integer addressId;
	private String doorNumber;
	private String street;
	private String locality;
	private String city;
	private String state;
	private String pinCode;
	private String country;
	@OneToOne
	@JoinColumn(name="userfk")
	private UserProfile user;
	
	public Address() {
		
	}

	public Address(Integer addressId, String doorNumber, String street, String locality, String city, String state,
			String pinCode, String country, UserProfile user) {
		super();
		this.addressId = addressId;
		this.doorNumber = doorNumber;
		this.street = street;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.country = country;
		this.user = user;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", doorNumber=" + doorNumber + ", street=" + street + ", locality="
				+ locality + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode + ", country=" + country
				+ ", user=" + user + "]";
	}
	
	




}
