package kth.iv1201.grupp10.recruitmentApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kth.iv1201.grupp10.recruitmentApplication.entity.UserEntity;


/**
 * Interface for database communication
 * @author siavash
 *
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	/**
	 * Fetches a user from the database found by email
	 * @param email the email of the user
	 * @return user
	 */
	public UserEntity findByEmail(String email);
}