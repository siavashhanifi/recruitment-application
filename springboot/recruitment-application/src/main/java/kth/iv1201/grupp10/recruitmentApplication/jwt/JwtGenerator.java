package kth.iv1201.grupp10.recruitmentApplication.jwt;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.*;
import kth.iv1201.grupp10.recruitmentApplication.entity.UserEntity;

/**
 * @author Siavash Hanifi
 * Handles the generation of JWTs.
 */
@Component
@Transactional(propagation=Propagation.REQUIRED)
public class JwtGenerator {

	private static final int JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;
	

	/**
	 * Generates a token for a user.
	 * @param userEntity, the user
	 * @return JWT
	 */
	public String generateToken(UserEntity userEntity) {
		Map<String, Object> claims = setClaims(userEntity);
		return doGenerateToken(claims, userEntity.getEmail());
	}

	private Map<String, Object> setClaims(UserEntity userEntity) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("role_id", userEntity.getRole().getRole_id());
		return claims;
	}
	
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
