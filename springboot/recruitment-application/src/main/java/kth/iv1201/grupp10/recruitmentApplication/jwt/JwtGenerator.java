package kth.iv1201.grupp10.recruitmentApplication.jwt;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import kth.iv1201.grupp10.recruitmentApplication.domain.UserLoginCredentials;

@Component
public class JwtGenerator {

	private static final int JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;

	public String generateToken(Map<String, Object> claims, UserLoginCredentials userLoginCredentials) {
		return doGenerateToken(claims, userLoginCredentials.getEmail());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
