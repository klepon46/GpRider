package com.ara.gprider.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="GP_RIDER")
public class GpRider {

	@Id
	@Column(name="RIDER_NAME", nullable=false)
	private String riderName;
	
	@Column(name="RIDER_BIKE")
	private String riderBike;
	
	@Column(name="RIDER_NUMBER")
	private String riderNumber;
	
	@Column(name="RIDER_PHOTO")
	@Lob
	private byte[] riderPhoto;
	
	public GpRider() {
		// TODO Auto-generated constructor stub
	}

	public String getRiderName() {
		return riderName;
	}

	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}

	public String getRiderBike() {
		return riderBike;
	}

	public void setRiderBike(String riderBike) {
		this.riderBike = riderBike;
	}

	public String getRiderNumber() {
		return riderNumber;
	}

	public void setRiderNumber(String riderNumber) {
		this.riderNumber = riderNumber;
	}

	public byte[] getRiderPhoto() {
		return riderPhoto;
	}

	public void setRiderPhoto(byte[] riderPhoto) {
		this.riderPhoto = riderPhoto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((riderName == null) ? 0 : riderName.hashCode());
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
		GpRider other = (GpRider) obj;
		if (riderName == null) {
			if (other.riderName != null)
				return false;
		} else if (!riderName.equals(other.riderName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GpRiderBean [riderName=" + riderName + "]";
	}
	
}
