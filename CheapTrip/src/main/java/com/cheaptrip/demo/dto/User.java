package com.cheaptrip.demo.dto;

import java.util.Date;
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
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String surnames;
	private String email;
	private String password;
	private String phone_number;
	private Date birth_date;
	private Date creation_date;
	
	@ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<BargainsUsers > bargainsUsers;
	
	/**Constructors */
	
	public User() {
		
	}
	

	/**
	 * @param id
	 * @param name
	 * @param surnames
	 * @param email
	 * @param password
	 * @param phone_number
	 * @param birth_date
	 * @param creation_date
	 * @param role
	 */
	public User(long id, String name, String surnames, String email, String password, String phone_number,
			Date birth_date, Date creation_date, Role role) {
		this.id = id;
		this.name = name;
		this.surnames = surnames;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.birth_date = birth_date;
		this.creation_date = creation_date;
		this.role = role;
	}



	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
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
	 * @return the surnames
	 */
	public String getSurnames() {
		return surnames;
	}

	/**
	 * @param surnames the surnames to set
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * @return the birth_date
	 */
	public Date getBirth_date() {
		return birth_date;
	}

	/**
	 * @param birth_date the birth_date to set
	 */
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	/**
	 * @return the creation_date
	 */
	public Date getCreation_date() {
		return creation_date;
	}

	/**
	 * @param creation_date the creation_date to set
	 */
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}


	/**
	 * @return the bargainsUsers
	 */
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


	
	
}
