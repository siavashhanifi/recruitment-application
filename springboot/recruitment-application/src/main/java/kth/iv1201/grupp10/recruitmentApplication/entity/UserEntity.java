package kth.iv1201.grupp10.recruitmentApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.DigestUtils;

import kth.iv1201.grupp10.recruitmentApplication.domain.UserRegistrationValues;

/**
 * @author Siavash
 * Represents a person-table in the relational database.
 * Used with to store and load from the database using jpa.
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
	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity role;
	@Column(unique = true)
	private String username;
	
	public UserEntity() {

	}
	
	public UserEntity(UserRegistrationValues user){
		this.name = user.getName();
		this.surname = user.getSurname();
		this.ssn = user.getSsn();
		this.email = user.getEmail();
		this.password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		this.role = new RoleEntity(user.getRole_id());
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
	public RoleEntity getRole() {
		return role;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole(RoleEntity role) {
		this.role = role;
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