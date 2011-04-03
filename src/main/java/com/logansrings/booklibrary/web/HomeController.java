package com.logansrings.booklibrary.web;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		logger.info("Welcome home!");
		return "home";
	}
	
	/**
	 * <p>Provide a model with a list of all authors.</p>
	 * 
	 * @param model the "implicit" model created by Spring MVC
	 */
	@RequestMapping("/authorlist")
	public String authorList(Model model) {
		
		model.addAttribute("authors", Collections.emptyList());
		return "authorlist";
	}

	/**
	 * <p>Provide a model with a list of all books.</p>
	 * 
	 * @param model the "implicit" model created by Spring MVC
	 */
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		
		model.addAttribute("books", Collections.emptyList());
		return "booklist";
	}
	
}

