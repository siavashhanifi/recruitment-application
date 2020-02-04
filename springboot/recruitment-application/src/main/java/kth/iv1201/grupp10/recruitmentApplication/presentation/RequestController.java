package kth.iv1201.grupp10.recruitmentApplication.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kth.iv1201.grupp10.recruitmentApplication.application.ApplicantService;
import kth.iv1201.grupp10.recruitmentApplication.domain.UserLoginCredentials;

/**
 * @author Siavash
 * Responsible for delegating client requests to the CurrencyConverterService and
 * presenting the correct response(html).
 */
@Controller
@Scope("session")
public class RequestController {

	@Autowired
	ApplicantService applicantService;

	/**
	 * Presents the index-page when "/" is requested by the client.
	 * @return index.html
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/api/auth/login", method = RequestMethod.POST)
	public @ResponseBody void processMessage(@RequestBody UserLoginCredentials userLoginCredentials) throws Exception{
		System.out.println("hej kuken");
	}



}