package com.logansrings.booklibrary.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.logansrings.booklibrary.model.User;
import com.logansrings.booklibrary.service.BookLibraryService;

/**
 * Handles registration and log in requests.
 */
@Controller
public class LogInController {

	@Autowired
	private BookLibraryService bookLibraryService;
	@Resource
	private AuthenticationManager authenticationManager;

	/**
	 * Handle registration request
	 * @param registeremail
	 * @param registerusername
	 * @param registerpassword
	 * @param registerpasswordconfirm
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/register")                         
	public String register(
			@RequestParam(value = "registeremail") String registeremail,
			@RequestParam(value = "registerusername") String registerusername,	
			@RequestParam(value = "registerpassword") String registerpassword,	
			@RequestParam(value = "registerpasswordconfirm") String registerpasswordconfirm,	
			Model model,
			HttpServletRequest request) {

		User user = bookLibraryService.register(registerusername, registerpassword, registeremail);
		if (user.isNotValid()) {
			// TODO inform user of error			
			System.out.println(user.getContext());
			return "login";
		} else {
			logInRegisteredUser(registerusername, registerpassword, request);
			return loggedIn(model);
		}
	}

	private void logInRegisteredUser(String username, String password, HttpServletRequest request) {
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(username, password);
	    token.setDetails(new WebAuthenticationDetails(request));
	    Authentication authenticatedUser = 
	    		authenticationManager.authenticate(token);
	    SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}

	/**
	 * <p>Provide a model with a list of all books for principal.</p>
	 * @param model the "implicit" model created by Spring MVC
	 */
	@Secured("ROLE_USER")
	@RequestMapping("/loggedin")
	public String loggedIn(Model model) {
		return library(model);
	}
	
	/**
	 * <p>Provide a model with a list of all books for principal.</p>
	 * @param model the "implicit" model created by Spring MVC
	 */
	@Secured("ROLE_USER")
	@RequestMapping("/library")
	public String library(Model model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("libraryBooks",
				bookLibraryService.getLibraryBooks(authentication.getName()));
		return "library";
	}

}
