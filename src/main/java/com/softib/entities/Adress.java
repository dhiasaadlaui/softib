package com.softib.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Adress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private User user;
	
	private String street;
	private String streetNumber;
	private String goverment;
	private String postalCode;
	private String isLegal;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getGoverment() {
		return goverment;
	}
	public void setGoverment(String goverment) {
		this.goverment = goverment;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getIsLegal() {
		return isLegal;
	}
	public void setIsLegal(String isLegal) {
		this.isLegal = isLegal;
	}
	public Adress(int id, String street, String streetNumber, String goverment, String postalCode, String isLegal) {
		super();
		this.id = id;
		this.street = street;
		this.streetNumber = streetNumber;
		this.goverment = goverment;
		this.postalCode = postalCode;
		this.isLegal = isLegal;
	}
	public Adress() {
		super();
	}
	@Override
	public String toString() {
		return "Adress [id=" + id + ", street=" + street + ", streetNumber=" + streetNumber + ", goverment=" + goverment
				+ ", postalCode=" + postalCode + ", isLegal=" + isLegal + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goverment == null) ? 0 : goverment.hashCode());
		result = prime * result + id;
		result = prime * result + ((isLegal == null) ? 0 : isLegal.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((streetNumber == null) ? 0 : streetNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		if (goverment == null) {
			if (other.goverment != null)
				return false;
		} else if (!goverment.equals(other.goverment))
			return false;
		if (id != other.id)
			return false;
		if (isLegal == null) {
			if (other.isLegal != null)
				return false;
		} else if (!isLegal.equals(other.isLegal))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (streetNumber == null) {
			if (other.streetNumber != null)
				return false;
		} else if (!streetNumber.equals(other.streetNumber))
			return false;
		return true;
	}
	
	
	
}
