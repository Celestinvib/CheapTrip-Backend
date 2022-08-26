package com.cheaptrip.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cities")
public class City {

	/**
	 * Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;


	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "origin")
	private List<Flight> origin;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "destination")
	private List<Flight> destination;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private List<Accommodation> accommodation;


	/**
	 * Constructors
	 */

	public City() {
	}


	/**
	 * GETTERS and SETTERS
	 */

	/**
	 * @param name
	 */
	public City(String name) {
		this.name = name;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}





	/**
	 * @return the origin
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
	public List<Flight> getOrigin() {
		return origin;
	}


	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(List<Flight> origin) {
		this.origin = origin;
	}


	/**
	 * @return the destination
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
	public List<Flight> getDestination() {
		return destination;
	}


	/**
	 * @param destination the destination to set
	 */
	public void setDestination(List<Flight> destination) {
		this.destination = destination;
	}


	/**
	 * @return the accommodation
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Accommodation")
	public List<Accommodation> getAccommodation() {
		return accommodation;
	}


	/**
	 * @param accommodation the accommodation to set
	 */
	public void setAccommodation(List<Accommodation> accommodation) {
		this.accommodation = accommodation;
	}


	/**
	 * ToString
	 */

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}


}
