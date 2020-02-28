package kth.iv1201.grupp10.recruitmentApplication.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kth.iv1201.grupp10.recruitmentApplication.domain.CredentialValidator;
import kth.iv1201.grupp10.recruitmentApplication.domain.InvalidLoginException;
import kth.iv1201.grupp10.recruitmentApplication.domain.InvalidRegistrationException;
import kth.iv1201.grupp10.recruitmentApplication.domain.UserRegistrationValues;
import kth.iv1201.grupp10.recruitmentApplication.domain.UserLoginCredentials;
import kth.iv1201.grupp10.recruitmentApplication.entity.UserEntity;
import kth.iv1201.grupp10.recruitmentApplication.jwt.JwtGenerator;
import kth.iv1201.grupp10.recruitmentApplication.jwt.JwtValidator;
import kth.iv1201.grupp10.recruitmentApplication.repository.UserRepository;

/**
 * @author Siavash Hanifi
 * Handles cross-layer communication between the CredentialValidator, JwtGenerator,
 * JwtValidator and userRepository.
 */
@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class UserService {

	@Autowired
	private CredentialValidator credentialValidator;

	@Autowired
	private JwtGenerator jwtGenerator;

	@Autowired
	private JwtValidator jwtValidator;

	@Autowired
	private UserRepository userRepository;
	
	private boolean uniqueRegistration(UserRegistrationValues user) throws InvalidRegistrationException {
		if (this.userRepository.findByEmail(user.getEmail()) != null) {
			throw new InvalidRegistrationException("invalid email");
		} else if (this.userRepository.findByUsername(user.getUsername()) != null) {
			throw new InvalidRegistrationException("invalid username");
		} else if (this.userRepository.findBySsn(user.getSsn()) != null) {
			throw new InvalidRegistrationException("invalid ssn");
		} else {
			return true;
		}
	}

	/**
	 * Attempts to log in a user based on login credentials.
	 * @param userLoginCredentials, the login credentials.
	 * @return if credentials are valid: JWT
	 * @throws Exception, thrown if credentials invalid.
	 */
	public String login(UserLoginCredentials userLoginCredentials) throws InvalidLoginException {
		boolean validCredentials = credentialValidator.validCredentials(userLoginCredentials);
		if (validCredentials) {
			UserEntity userEntity = this.userRepository.findByEmail(userLoginCredentials.getEmail());
			System.out.println(userEntity.getEmail());
			return jwtGenerator.generateToken(userEntity);
		} else {
			return "";
		}
	}

	/**
	 * Attempts to register a user
	 * @param user, the user.
	 * @throws Exception, thrown if user already is registered.
	 */
	public void register(UserRegistrationValues user) throws InvalidRegistrationException {
		if (uniqueRegistration(user)) {
			UserEntity userEntity = new UserEntity(user);
			this.userRepository.save(userEntity);
		}
	}

	/**
	 * Checks if a token is valid.
	 * @param jwtToken
	 * @return true if valid, false if invalid
	 */
	public boolean tokenValid(String jwtToken) {
		boolean tokenValid = this.jwtValidator.isValid(jwtToken);
		return tokenValid;

	}

}
