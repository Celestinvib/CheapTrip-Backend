package com.cheaptrip.demo.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="accounts")
public class Account  implements UserDetails{

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
	private int status;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "accounts_roles",
        joinColumns = @JoinColumn(name = "account_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>(); 
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<BargainsAccounts > bargainsAccounts;
	
	/**Constructors */
	
	public Account() {
		
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
	 * @param status
	 * @param role
	 */
	public Account(long id, String name, String surnames, String email, String password, String phone_number,
			Date birth_date, Date creation_date, int status) {
		super();
		this.id = id;
		this.name = name;
		this.surnames = surnames;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.birth_date = birth_date;
		this.creation_date = creation_date;
		this.status = status;
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

    
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
 
    public Set<Role> getRoles() {
        return roles;
    }
 
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
     
    public void addRole(Role role) {
        this.roles.add(role);
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
	 * @return the bargainsAccounts
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "BargainsAccounts")
	public List<BargainsAccounts> getBargainsAccounts() {
		return bargainsAccounts;
	}


	/**
	 * @param bargainsAccounts the bargainsAccounts to set
	 */
	public void setBargainsAccounts(List<BargainsAccounts> bargainsAccounts) {
		this.bargainsAccounts = bargainsAccounts;
	}


	/**
	 * ToString
	 */
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surnames=" + surnames + ", email=" + email + ", password="
				+ password + ", phone_number=" + phone_number + ", birth_date=" + birth_date + ", creation_date="
				+ creation_date+ "]";
	}

	@Override
	public String getUsername() {
		return this.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}





	
	
}
