package com.logansrings.booklibrary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("books", bookLibraryService.getBooks());
		return "booklist";
	}

	@RequestMapping(value="/addauthors", method=RequestMethod.GET)
	public String addAuthors() {
		return "addauthor";
	}
	
	@RequestMapping("/addauthor")
	public String addAuthor(
			@RequestParam(value = "authorfirstname") String registeremail,
			@RequestParam(value = "authorlastname") String registerusername,
			Model model) {
		
		return null;
	}
}

