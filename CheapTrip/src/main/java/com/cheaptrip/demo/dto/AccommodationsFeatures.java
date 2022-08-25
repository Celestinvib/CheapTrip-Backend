package com.cheaptrip.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="accommodationsFeatures")
public class AccommodationsFeatures {
	
	/**Attributes */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Find last value and increment from final id of db
	private Long id;
	
	private int accommodation_id;
	
	private int feature_id;
	
	@ManyToOne
	@JoinColumn(name="accommodationsFeatures")
    private List<Bargain> accommodation;
	
	@ManyToOne
	@JoinColumn(name="accommodationsFeatures")
    private List<Bargain> feature;
	
	/**Constructors */
	public AccommodationsFeatures() {
		
	}
	
	/**
	 * @param id
	 * @param accommodation_id
	 * @param feature_id
	 */
	
	public AccommodationsFeatures(Long id, int accommodation_id, int feature_id) {
		this.id = id;
		this.setAccommodation_id(accommodation_id);
		this.setFeature_id(feature_id);
	}

	public int getFeature_id() {
		return feature_id;
	}

	public void setFeature_id(int feature_id) {
		this.feature_id = feature_id;
	}

	public int getAccommodation_id() {
		return accommodation_id;
	}

	public void setAccommodation_id(int accommodation_id) {
		this.accommodation_id = accommodation_id;
	}
	
	
	
}