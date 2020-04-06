package com.hibernate.flight.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "FLIGHT_MAS")
public class Flight {
	
	@Column(name="FLIGHT_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="FLIGHT_REF_NO")
	private String refNo;
	
	@Column(name="FLIGHT_DT")
	private Date flightDate;
	
	@Column(name="BOOKED_BY")
	private String bookedBy;
	
	public Flight() {
		
	}

	public Flight(String refNo, Date flightDate, String bookedBy) {
		super();
		this.refNo = refNo;
		this.flightDate = flightDate;
		this.bookedBy = bookedBy;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}

	@Override
	public String toString() {
		return "Flight [Id=" + Id + ", refNo=" + refNo + ", flightDate=" + flightDate + ", bookedBy=" + bookedBy + "]";
	}
	
	
	
	

}
