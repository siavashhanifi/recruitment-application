package kth.iv1201.grupp10.recruitmentApplication.domain;

import org.springframework.stereotype.Component;

/**
 * @author Siavash
 * Represents the user login credentials.
 * Is used for parsing a JSON object that holds login credentials.
 */
@Component
public class UserLoginCredentials {
	private String email;
	private String password;
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
	
	
}
