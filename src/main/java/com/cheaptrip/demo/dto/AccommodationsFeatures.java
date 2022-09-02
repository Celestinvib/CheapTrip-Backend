package com.cheaptrip.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="accommodations_features")
public class AccommodationsFeatures {
	
	/**Attributes */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Find last value and increment from final id of db
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="accommodation_id")
    private Accommodation accommodation;
	
	@ManyToOne
	@JoinColumn(name="feature_id")
    private Feature feature;
	
	/**Constructors */
	public AccommodationsFeatures() {
		
	}

	/**
	 * @param accommodation
	 * @param feature
	 */
	public AccommodationsFeatures(Accommodation accommodation, Feature feature) {
		this.accommodation = accommodation;
		this.feature = feature;
	}

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
	 * @return the accommodation
	 */
	public Accommodation getAccommodation() {
		return accommodation;
	}

	/**
	 * @param accommodation the accommodation to set
	 */
	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

	/**
	 * @return the feature
	 */
	public Feature getFeature() {
		return feature;
	}

	/**
	 * @param feature the feature to set
	 */
	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "AccommodationsFeatures [id=" + id + ", accommodation=" + accommodation + ", feature=" + feature + "]";
	}
	
}