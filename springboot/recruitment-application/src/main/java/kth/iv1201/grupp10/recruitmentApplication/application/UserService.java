package kth.iv1201.grupp10.recruitmentApplication.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kth.iv1201.grupp10.recruitmentApplication.domain.CredentialValidator;
import kth.iv1201.grupp10.recruitmentApplication.domain.User;
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
	
	private boolean alreadyRegistered(User user){
		return this.userRepository.findByEmail(user.getEmail()) != null;
	}

	/**
	 * Attempts to log in a user based on login credentials.
	 * @param userLoginCredentials, the login credentials.
	 * @return if credentials are valid: JWT
	 * @throws Exception, thrown if credentials invalid.
	 */
	public String login(UserLoginCredentials userLoginCredentials) throws Exception {
		boolean validCredentials = credentialValidator.validCredentials(userLoginCredentials);
		if (!validCredentials) {
			throw new Exception("Invalid credentials");
		} else {
			UserEntity userEntity = this.userRepository.findByEmail(userLoginCredentials.getEmail());
			return jwtGenerator.generateToken(userEntity);
		}
	}

	/**
	 * Attempts to register a user
	 * @param user, the user.
	 * @throws Exception, thrown if user already is registered.
	 */
	public void register(User user) throws Exception {
		if (alreadyRegistered(user)) {
			throw new Exception("already registered");
		} else {
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
