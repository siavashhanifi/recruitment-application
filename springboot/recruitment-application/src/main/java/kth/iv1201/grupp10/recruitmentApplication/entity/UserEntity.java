package kth.iv1201.grupp10.recruitmentApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import kth.iv1201.grupp10.recruitmentApplication.domain.User;

/**
 * @author Siavash
 * Database user representation
 */
@Entity
@Table(name="person")
public class UserEntity {
	

    @Id
    @GeneratedValue
	private int person_id;
	private String name;
	private String surname;
	@Column(unique = true)
	private String ssn;
	@Column(unique = true)
	private String email;
	private String password;
	private int role_id;
	@Column(unique = true)
	private String username;
	
	/**
	 * Constructor
	 */
	public UserEntity() {

	}
	
	/**
	 * Creates an user entity from a user object
	 * @param user
	 */
	public UserEntity(User user) {
		this.name = user.getName();
		this.surname = user.getSurname();
		this.ssn = user.getSsn();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.role_id = user.getRole_id();
		this.username = user.getUsername();
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
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
	 * @return the role_id
	 */
	public int getRole_id() {
		return role_id;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(int role_id) {
		this.role_id = role_id;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}