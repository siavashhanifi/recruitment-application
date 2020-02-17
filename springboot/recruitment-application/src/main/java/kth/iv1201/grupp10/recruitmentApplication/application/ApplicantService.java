package kth.iv1201.grupp10.recruitmentApplication.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kth.iv1201.grupp10.recruitmentApplication.domain.Authenticator;
import kth.iv1201.grupp10.recruitmentApplication.domain.User;
import kth.iv1201.grupp10.recruitmentApplication.domain.UserLoginCredentials;
import kth.iv1201.grupp10.recruitmentApplication.entity.UserEntity;
import kth.iv1201.grupp10.recruitmentApplication.repository.UserRepository;

/**
 * @author Siavash
 * Calls the appropriate methods in the domain to serve the client. 
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ApplicantService {
	
	@Autowired
	private Authenticator authenticator;
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean validCredentials(UserLoginCredentials userLoginCredentials) {
		return this.authenticator.validCredentials(userLoginCredentials);
	}
	
	public void register(User user) {
		UserEntity userEntity = new UserEntity(user);
		this.userRepository.save(userEntity);
	}

}
