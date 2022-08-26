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
@Table(name="roles")
public class Role {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private List<User> user;

	
	
	//Constructors
	
	public Role() {
	}


	/**
	 * @param name
	 */
	public Role(String name) {
		this.name = name;
	}


	//GETTERS and SETTERS
	
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
	 * @return the user
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "User")
	public List<User> getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(List<User> user) {
		this.user = user;
	}


	//ToString
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
