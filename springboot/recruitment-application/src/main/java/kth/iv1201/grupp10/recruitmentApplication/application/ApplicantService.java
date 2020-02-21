package kth.iv1201.grupp10.recruitmentApplication.application;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
 * @author Siavash Calls the appropriate methods in the domain to serve the
 *         client.
 */
@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
public class ApplicantService {

	@Autowired
	private CredentialValidator credentialValidator;

	@Autowired
	private JwtGenerator jwtGenerator;

	@Autowired
	private JwtValidator jwtValidator;

	@Autowired
	private UserRepository userRepository;

	public String login(UserLoginCredentials userLoginCredentials) throws Exception {
		boolean validCredentials = credentialValidator.validCredentials(userLoginCredentials);
		if (!validCredentials) {
			throw new Exception("Invalid credentials");
		} else {
			UserEntity userEntity = this.userRepository.findByEmail(userLoginCredentials.getEmail());
			return jwtGenerator.generateToken(userEntity);
		}
	}

	public void register(User user) throws Exception {
		if (alreadyRegistered(user)) {
			throw new Exception("already registered");
		} else {
			UserEntity userEntity = new UserEntity(user);
			this.userRepository.save(userEntity);
		}

	}

	public boolean alreadyRegistered(User user){
		return this.userRepository.findByEmail(user.getEmail()) != null;
	}

	public boolean isValid(String jwtToken) {
		boolean tokenIsValid = this.jwtValidator.isValid(jwtToken);
		return tokenIsValid;

	}

}
