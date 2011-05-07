package com.logansrings.booklibrary.web;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logansrings.booklibrary.service.BookLibraryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private BookLibraryService bookLibraryService;
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		
	/**
	 * <p>Provide a model with a list of all authors.</p>
	 * @param model the "implicit" model created by Spring MVC
	 */
	@RequestMapping("/authorlist")
	public String authorList(Model model) {		
		model.addAttribute("authors", bookLibraryService.getAuthors());
		return "authorlist";
	}

	/**
	 * <p>Provide a model with a list of all books.</p>
	 * @param model the "implicit" model created by Spring MVC
	 */
	@RequestMapping("/booklist")
	public String bookList(Model model) {
//		List<Book> list = new ArrayList<Book>();
//		list.add(Book.getTestBook());
//		model.addAttribute("books", list);
		model.addAttribute("books", bookLibraryService.getBooks());
		return "booklist";
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
	
	/**
	 * <p>Registration redirects to register.</p>
	 * @param model the "implicit" model created by Spring MVC
	 * @return 
	 */
	@RequestMapping("/registration")
	public String registration(Model model) {
		return "register";
	}
		
}

