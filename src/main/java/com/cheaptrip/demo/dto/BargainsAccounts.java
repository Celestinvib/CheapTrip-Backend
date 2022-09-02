package com.cheaptrip.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bargains_accounts")
public class BargainsAccounts {
	
	/**Attributes */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Find last value and increment from final id of db
	private Long id;
	
	private int booked;
	
	private int bookmarked;
	
	@ManyToOne
	@JoinColumn(name="account_id")
    private Account account;
	
	@ManyToOne
	@JoinColumn(name="bargain_id")
    private Bargain bargain;
	
	
	/**Constructors */
	public BargainsAccounts() {
		
	}
	
	/**
	 * @param id
	 * @param booked
	 * @param bookmarked
	 * @param account
	 * @param bargain
	 */
	public BargainsAccounts(Long id, int booked, int bookmarked, Account account, Bargain bargain) {
		this.id = id;
		this.booked = booked;
		this.bookmarked = bookmarked;
		this.account = account;
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
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
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

	
	/**
	 * ToString
	 */
	
	@Override
	public String toString() {
		return "BargainsUsers [id=" + id + ", booked=" + booked + ", bookmarked=" + bookmarked + ", account=" + account
				+ ", bargain=" + bargain + "]";
	}

}
