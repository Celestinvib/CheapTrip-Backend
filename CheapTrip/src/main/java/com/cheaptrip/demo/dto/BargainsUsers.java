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
	
	private int statusbook;
	
	private int statusbookmarked;
	
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
	 * @param user
	 * @param bargain
	 */
	public BargainsUsers(User user, Bargain bargain, int statusbook, int statusbookmarked) {
		this.user = user;
		this.bargain = bargain;
		this.statusbook = statusbook;
		this.statusbookmarked = statusbookmarked;
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
	 * @return the statusbook
	 */
	public int getStatusbook() {
		return statusbook;
	}

	/**
	 * @param statusbook the statusbook to set
	 */
	public void setStatusbook(int statusbook) {
		this.statusbook = statusbook;
	}

	/**
	 * @return the statusbookmarked
	 */
	public int getStatusbookmarked() {
		return statusbookmarked;
	}

	/**
	 * @param statusbookmarked the statusbookmarked to set
	 */
	public void setStatusbookmarked(int statusbookmarked) {
		this.statusbookmarked = statusbookmarked;
	}
	
		
}
