package kth.iv1201.grupp10.recruitmentApplication.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import kth.iv1201.grupp10.recruitmentApplication.entity.UserEntity;
import kth.iv1201.grupp10.recruitmentApplication.repository.UserRepository;

/**
 * @author Siavash
 * Handles credential validation.
 */
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class CredentialValidator {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * Validates user login credentials.
	 * Checks if email is registered and if the password is correct.
	 * @param userLoginCredentials
	 * @return
	 */
	public boolean validCredentials(UserLoginCredentials userLoginCredentials) throws InvalidLoginException {
		String email = userLoginCredentials.getEmail();
		String password = userLoginCredentials.getPassword();
		if(emailRegistered(email)) {
			if(validPassword(email, password)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean emailRegistered(String email) throws InvalidLoginException {
		if(userRepository.findByEmail(email) == null) {
			throw new InvalidLoginException("invalid email");
		}
		else {
			return true;
		}
	}

	private boolean validPassword(String email, String password) throws InvalidLoginException {
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
		UserEntity userEntity = userRepository.findByEmail(email);
		if(md5Password.compareTo(userEntity.getPassword()) == 0) {
			return true;
		} else {
			throw new InvalidLoginException("invalid password");
		}
	}
	
}
