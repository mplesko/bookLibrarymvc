package com.logansrings.booklibrary.web;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.util.Collections;

import javax.annotation.Resource;
import javax.inject.Qualifier;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.logansrings.booklibrary.model.User;
import com.logansrings.booklibrary.service.BookLibraryService;

/**
 * Handles registration and log in requests.
 */
@Controller
public class LogInController {

	@Autowired
	private BookLibraryService bookLibraryService;

	//	@Autowired 
	@Resource
	private AuthenticationManager authenticationManager;

	
	/**
	 * Handle registration request
	 * @param request
	 * @param model
	 * @return
	 */
//	@RequestMapping(value="/register", method=RequestMethod.POST)                         
	@RequestMapping(value="/register")                         
	public String register(HttpServletRequest request, Model model) {
		return "library";
	}

	/**
	 * <p>Provide a model with a list of all books for principal.</p>
	 * @param model the "implicit" model created by Spring MVC
	 */
	@Secured("ROLE_USER")
	@RequestMapping("/loggedin")
	public String loggedIn(Model model) {
		final String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

		model.addAttribute("libraryBooks", Collections.EMPTY_LIST);
		return "library";
	}
}
