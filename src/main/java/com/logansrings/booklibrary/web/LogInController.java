package com.logansrings.booklibrary.web;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles registration and log in requests.
 */
@Controller
@RequestMapping("/register")
public class LogInController {

	/**
	 * <p>Register the user.</p>
	 * @param model the "implicit" model created by Spring MVC
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("registerBean", new RegisterBean());
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)                         
	public String form(@ModelAttribute("user") RegisterBean registerBean, BindingResult result, Model model) {
		model.addAttribute("libraryBooks", Collections.EMPTY_LIST);
		return "library";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields(new String[] {"email", "username", "password"});
	}
	
	private void verifyBinding(BindingResult result) { }
}