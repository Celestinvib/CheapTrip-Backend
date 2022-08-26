package com.cheaptrip.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bargains_users")
public class BargainsUsers {
	
	/**Attributes */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Find last value and increment from final id of db
	private Long id;
	
	private int booked;
	
	private int bookmarked;
	
	@ManyToOne
	@JoinColumn(name="user_id")
    private User user;
	
	@ManyToOne
	@JoinColumn(name="bargain_id")
    private Bargain bargain;
	
	
	/**Constructors */
	public BargainsUsers() {
		
	}
	
	/**
	 * @param id
	 * @param booked
	 * @param bookmarked
	 * @param user
	 * @param bargain
	 */
	public BargainsUsers(Long id, int booked, int bookmarked, User user, Bargain bargain) {
		this.id = id;
		this.booked = booked;
		this.bookmarked = bookmarked;
		this.user = user;
		this.bargain = bargain;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the bargain
	 */
	public Bargain getBargain() {
		return bargain;
	}

	/**
	 * @param bargain the bargain to set
	 */
	public void setBargain(Bargain bargain) {
		this.bargain = bargain;
	}

	/**
	 * @return the booked
	 */
	public int getBooked() {
		return booked;
	}

	/**
	 * @param booked the booked to set
	 */
	public void setBooked(int booked) {
		this.booked = booked;
	}

	/**
	 * @return the bookmarked
	 */
	public int getBookmarked() {
		return bookmarked;
	}

	/**
	 * @param bookmarked the bookmarked to set
	 */
	public void setBookmarked(int bookmarked) {
		this.bookmarked = bookmarked;
	}


	
		
}
