package com.cheaptrip.demo.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="flights")
public class Flight {
	
	/**Attributes */
	
	@Id
	private String id;
	
	@DateTimeFormat
	private Date departure_date;
	
	@DateTimeFormat
	private Date arrival_date;
	
	@ManyToOne
    @JoinColumn(name="origin")
    private City origin ;
	
	@ManyToOne
    @JoinColumn(name="destination ")
    private City destination ;
	
	private int status;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "outbound_flight")
    private List<Bargain> bargain_outbound_flight;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "return_flight")
    private List<Bargain> bargain_return_flight;
	
	/**Constructors */

	public Flight() {
		
	}

	/**
	 * @param id
	 * @param departure_date
	 * @param arrival_date
	 * @param origin
	 * @param destination
	 * @param status
	 */
	public Flight(String id, Date departure_date, Date arrival_date, City origin, City destination, int status) {
		this.id = id;
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
		this.origin = origin;
		this.destination = destination;
		this.status = status;
	}

	/**Getters y Setters*/

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the departure_date
	 */
	public Date getDeparture_date() {
		return departure_date;
	}

	/**
	 * @param departure_date the departure_date to set
	 */
	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}

	/**
	 * @return the arrival_date
	 */
	public Date getArrival_date() {
		return arrival_date;
	}

	/**
	 * @param arrival_date the arrival_date to set
	 */
	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}

	/**
	 * @return the origin
	 */
	public City getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(City origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public City getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(City destination) {
		this.destination = destination;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	/**
	 * @return the bargain_outbound_flight
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Bargain")
	public List<Bargain> getBargain_outbound_flight() {
		return bargain_outbound_flight;
	}

	/**
	 * @param bargain_outbound_flight the bargain_outbound_flight to set
	 */
	public void setBargain_outbound_flight(List<Bargain> bargain_outbound_flight) {
		this.bargain_outbound_flight = bargain_outbound_flight;
	}

	/**
	 * @return the bargain_return_flight
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Bargain")
	public List<Bargain> getBargain_return_flight() {
		return bargain_return_flight;
	}

	/**
	 * @param bargain_return_flight the bargain_return_flight to set
	 */
	public void setBargain_return_flight(List<Bargain> bargain_return_flight) {
		this.bargain_return_flight = bargain_return_flight;
	}

	/**
	 * Method printing data by console
	 */
	@Override
	public String toString() {
		return "Flight [id=" + id + ", departure_date=" + departure_date  + ", arrival_date=" + arrival_date  + ", origin=" + origin + ", destination=" + destination + ", status=" + status + "]";
	}
	

}
