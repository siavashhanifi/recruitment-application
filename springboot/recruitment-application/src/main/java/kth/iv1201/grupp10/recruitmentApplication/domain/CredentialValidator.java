package kth.iv1201.grupp10.recruitmentApplication.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kth.iv1201.grupp10.recruitmentApplication.entity.UserEntity;
import kth.iv1201.grupp10.recruitmentApplication.repository.UserRepository;

/**
 * @author Siavash
 * Handles the business logic for converting the currencies.
 */


@Component
public class CredentialValidator {
	
	@Autowired
	private UserRepository userRepository;

	public boolean validCredentials(UserLoginCredentials userLoginCredentials) {
		String email = userLoginCredentials.getEmail();
		String password = userLoginCredentials.getPassword();
		UserEntity userEntity = userRepository.findByEmail(email);
		if(emailRegistered(email)) {
			if(password.compareTo(userEntity.getPassword()) == 0)
				return true;
		}
		return false;
	}
	
	private boolean emailRegistered(String email) {
		if(userRepository.findByEmail(email) == null) return false;
		else return true;
	}
	
}
