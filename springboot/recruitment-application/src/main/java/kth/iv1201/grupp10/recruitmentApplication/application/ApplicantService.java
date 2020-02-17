package kth.iv1201.grupp10.recruitmentApplication.application;

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
 * @author Siavash
 * Calls the appropriate methods in the domain to serve the client. 
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ApplicantService {
	
	@Autowired
	private CredentialValidator credentialValidator;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@Autowired
	private JwtValidator jwtValidator;
	
	@Autowired
	private UserRepository userRepository;
	
	public String login(UserLoginCredentials userLoginCredentials) {
		boolean validCredentials = credentialValidator.validCredentials(userLoginCredentials);
		if(validCredentials) {
			UserEntity userEntity = this.userRepository.findByEmail(userLoginCredentials.getEmail());
			return jwtGenerator.generateToken(userEntity);
		}
		else return "";
	}
	
	public void register(User user) {
		UserEntity userEntity = new UserEntity(user);
		this.userRepository.save(userEntity);
	}

	public boolean isRecruit(String jwtToken) {
		int authClaim = this.jwtValidator.getAuthorizationClaim(jwtToken);
		if(authClaim == 2)
			return true;
		else
			return false;
	}

}
