package com.logansrings.booklibrary.web;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
//		logger.info("Welcome home!");
		return "home";
	}
	
	/**
	 * Simply redirects to the login view by returning its name.
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
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
	
}

