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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="flights")
public class Flight {
	
	/**Attributes */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Find last value and increment from final id of db
	private Long id;
	
	private Date departure_date;

	private Date arrival_date;
	
	@ManyToOne
    @JoinColumn(name="origin")
    private City origin ;
	
	@ManyToOne
    @JoinColumn(name="destination ")
    private City destination ;
	
	private int status;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    private List<Bargain> bargain;
	
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
	public Flight(Long id, Date departure_date, Date arrival_date, City origin, City destination, int status) {
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
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	 * @return the bargain
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Bargain")
	public List<Bargain> getBargain() {
		return bargain;
	}

	/**
	 * @param bargain the bargain to set
	 */
	public void setBargain(List<Bargain> bargain) {
		this.bargain = bargain;
	}

	/**
	 * Method printing data by console
	 */
	@Override
	public String toString() {
		return "Flight [id=" + id + ", departure_date=" + departure_date  + ", arrival_date=" + arrival_date  + ", origin=" + origin + ", destination=" + destination + ", status=" + status + "]";
	}
	

}
