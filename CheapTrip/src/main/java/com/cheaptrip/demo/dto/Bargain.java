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
@Table(name="bargains")
public class Bargain {
	
	/**Attributes */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Find last value and increment from final id of db
	private Long id;
	
	private String title;
	
	private String image;
	
	private double price;
	
	private String  description;
	
	private Date expiration_date;
	
	@ManyToOne
    @JoinColumn(name="accomodation_id")
    private Accommodation accomodation;
	
	@ManyToOne
    @JoinColumn(name="outbound_flight")
    private Flight outbound_flight;
    
	@ManyToOne
    @JoinColumn(name="return_flight")
    private Flight return_flight ;
	
	private int status;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bargain")
    private List<BargainsUsers> bargainsUsers;

	/**Constructors */
	
	public Bargain() {
		
	}
	
	/**
	 * @param id
	 * @param title
	 * @param image
	 * @param price
	 * @param description
	 * @param expiration_date
	 * @param accomodation
	 * @param outbound_flight
	 * @param return_flight
	 * @param status
	 */
	public Bargain(Long id, String title, String image, double price, String description, Date expiration_date,
			Accommodation accomodation, Flight outbound_flight, Flight return_flight, int status) {
		this.id = id;
		this.title = title;
		this.image = image;
		this.price = price;
		this.description = description;
		this.expiration_date = expiration_date;
		this.accomodation = accomodation;
		this.outbound_flight = outbound_flight;
		this.return_flight = return_flight;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}


	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the expiration_date
	 */
	public Date getExpiration_date() {
		return expiration_date;
	}


	/**
	 * @param expiration_date the expiration_date to set
	 */
	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}


	/**
	 * @return the accomodation
	 */
	public Accommodation getAccomodation() {
		return accomodation;
	}


	/**
	 * @param accomodation the accomodation to set
	 */
	public void setAccomodation(Accommodation accomodation) {
		this.accomodation = accomodation;
	}


	/**
	 * @return the outbound_flight
	 */
	public Flight getOutbound_flight() {
		return outbound_flight;
	}


	/**
	 * @param outbound_flight the outbound_flight to set
	 */
	public void setOutbound_flight(Flight outbound_flight) {
		this.outbound_flight = outbound_flight;
	}


	/**
	 * @return the return_flight
	 */
	public Flight getReturn_flight() {
		return return_flight;
	}


	/**
	 * @param return_flight the return_flight to set
	 */
	public void setReturn_flight(Flight return_flight) {
		this.return_flight = return_flight;
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
	 * @return the bargainsUsers
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "BargainsUsers")
	public List<BargainsUsers> getBargainsUsers() {
		return bargainsUsers;
	}

	/**
	 * @param bargainsUsers the bargainsUsers to set
	 */
	public void setBargainsUsers(List<BargainsUsers> bargainsUsers) {
		this.bargainsUsers = bargainsUsers;
	}
	
	/**
	 * Method printing data by console
	 */
	@Override
	public String toString() {
		return "Bargain [id=" + id + ", title=" + title  + ", image=" + image  + ", price=" + price + ", description=" + description + ", expiration_date=" + expiration_date + ", accomodation=" + accomodation  + ", outbound_flight=" + outbound_flight+ ", return_flight=" + return_flight+ ", status=" + status+ "]";
	}

	
	
	
	
}
