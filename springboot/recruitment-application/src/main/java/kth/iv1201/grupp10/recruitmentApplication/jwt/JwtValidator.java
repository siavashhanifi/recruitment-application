package kth.iv1201.grupp10.recruitmentApplication.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	
	@Value("${jwt.secret}")
	private String secret;

	public boolean isValid(String jwtToken) {
		return Jwts.parser().setSigningKey(secret).isSigned(jwtToken);
	}

	private Claims getAllClaimsFromToken(String token) {

		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

	}

}
