package com.cheaptrip.demo.dto;

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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="accommodations")
public class Accommodation {
	
	/**Attributes */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Find last value and increment from final id of db
	private Long id;
	
	private String name;
	
	private String address;
	
	private String category;
	
	private double latitude;
	
	private double longitude;
	
	private double rating;
	
	private int status;
	
	@ManyToOne
    @JoinColumn(name="city_id")
    private City city;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accommodation")
    private List<Bargain> bargain;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accommodation")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private List<AccommodationsFeatures > accommodationsFeatures;
    
    
	/**Constructors */
	public Accommodation() {
		
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param category
	 * @param latitude
	 * @param longitude
	 * @param rating
	 * @param status
	 * @param city
	 */
	public Accommodation(Long id, String name, String address, String category, double latitude, double longitude,
			double rating, int status, City city) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.category = category;
		this.latitude = latitude;
		this.longitude = longitude;
		this.rating = rating;
		this.status = status;
		this.city = city;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
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
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
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
	 * @return the accommodationsFeatures
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AccommodationsFeatures")
	public List<AccommodationsFeatures> getAccommodationsFeatures() {
		return accommodationsFeatures;
	}

	/**
	 * @param accommodationsFeatures the accommodationsFeatures to set
	 */
	public void setAccommodationsFeatures(List<AccommodationsFeatures> accommodationsFeatures) {
		this.accommodationsFeatures = accommodationsFeatures;
	}
	


	/**
	 * Method printing data by console
	 */
	@Override
	public String toString() {
		return "Accomodation [id=" + id + ", name=" + name  + ", address=" + address  + ", category=" + category + ", latitude=" + latitude + ", longitude=" + longitude + ", rating=" + rating  + ", city=" + city+ ", status=" + status+ "]";
	}

	
	
	
	
}
