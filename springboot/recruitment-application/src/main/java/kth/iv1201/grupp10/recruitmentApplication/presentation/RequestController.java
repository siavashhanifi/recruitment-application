package kth.iv1201.grupp10.recruitmentApplication.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kth.iv1201.grupp10.recruitmentApplication.application.UserService;
import kth.iv1201.grupp10.recruitmentApplication.domain.UserRegistrationValues;
import kth.iv1201.grupp10.recruitmentApplication.domain.UserLoginCredentials;

/**
 * @author Siavash Hanifi
 * Responsible for handling client requests.
 */
@Controller
@Scope("session")
public class RequestController {

	@Autowired
	UserService userService;

	/**
	 * Presents the index-page when "/" is requested by the client.
	 * @return index.html
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * Handles the client's request to validate a JWT.
	 * @param authorization, the header tag holding the JWT
	 * @return
	 */
	@GetMapping("/api/auth/validToken")
	public @ResponseBody String authenticate(@RequestHeader("Authorization") String authorization) {
		String jwtToken = authorization.substring(7);
		boolean tokenValid = userService.tokenValid(jwtToken);
		if (tokenValid)
			return "{\"validToken\" : \"true\"}";
		else
			return "{\"validToken\" : \"false\"}";
	}

	/**
	 * Handles a user's request to login.
	 * @param userLoginCredentials, the login credentials
	 * @return if credentials are valid: JWT
	 * @throws Exception thrown if credentials are invalid.
	 */
	@RequestMapping(value = "/api/auth/login", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody UserLoginCredentials userLoginCredentials) throws Exception {
		try {
			return "{\"token\" : \"" + userService.login(userLoginCredentials) + "\"}";
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Handles a user's request to register.
	 * @param user, the user.
	 * @throws Exception
	 */
	@RequestMapping(value = "/api/auth/register", method = RequestMethod.POST)
	public @ResponseBody void register(@RequestBody UserRegistrationValues user) throws Exception {
		try {
			userService.register(user);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

}