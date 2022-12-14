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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="features")
public class Feature {

	/**
	 * Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name",unique=true)
	private String name;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "feature")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<AccommodationsFeatures> accommodationsFeatures;



	/**
	 * Constructors
	 */

	public Feature() {
	}


	/**
	 * @param name
	 */
	public Feature(String name) {
		this.name = name;
	}


	/**
	 * GETTERS and SETTERS
	 */

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
	 * @return the accommodationsFeatures
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accommodationsFeatures")
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
	 * ToString
	 */

	@Override
	public String toString() {
		return "Feature [id=" + id + ", name=" + name + "]";
	}

}
