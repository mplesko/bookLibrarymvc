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
	 * <p>Register the user.</p>
	 * @param model the "implicit" model created by Spring MVC
	 * @return 
	 */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("registerBean", new RegisterBean());
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)                         
	public String register(@ModelAttribute("user") RegisterBean registerBean, BindingResult result, HttpServletRequest request, Model model) {
		User user = bookLibraryService.register(
				registerBean.getUsername(), 
				registerBean.getPassword(),
				registerBean.getEmail());
		
		if (user.isNotValid()) {
			model.addAttribute("registerBean", registerBean);
			return "register";
		}

		UsernamePasswordAuthenticationToken token = 
			new UsernamePasswordAuthenticationToken(registerBean.getUsername(), 
					registerBean.getPassword());

		// generate session if one doesn't exist
		request.getSession();
		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authentication = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		model.addAttribute("libraryBooks", Collections.EMPTY_LIST);
		return "library";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields(new String[] {"email", "username", "password", "passwordConfirm"});
	}

	private void verifyBinding(BindingResult result) { }

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
