package kth.iv1201.grupp10.recruitmentApplication.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

/**
 * @author Siavash
 * Handles the validation of JWTs.
 */
@Component
public class JwtValidator {

	@Value("${jwt.secret}")
	private String secret;

	/**
	 * Checks if a JWT is signed with the correct secret key.
	 * @param JWT, the JWT
	 * @return true if valid, false if invalid
	 */
	public boolean isValid(String jwtToken) {
		return Jwts.parser().setSigningKey(secret).isSigned(jwtToken);
	}

}
