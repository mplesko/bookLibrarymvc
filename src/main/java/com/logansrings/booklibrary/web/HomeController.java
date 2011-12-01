package com.logansrings.booklibrary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.logansrings.booklibrary.model.Author;
import com.logansrings.booklibrary.model.Book;
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
			@RequestParam(value = "authorfirstname") String authorFirstName,
			@RequestParam(value = "authorlastname") String authorLastName,
			Model model) {
		
		Author author = bookLibraryService.addAuthor(authorFirstName, authorLastName);
		if (author.isNotValid()) {
			// TODO inform user of error			
			System.out.println(author.getContext());
			return addAuthors();
		} else {
			return addAuthors();
		}
	}

	@RequestMapping(value="/addbooks", method=RequestMethod.GET)
	public String addBooks(Model model) {
		model.addAttribute("addBookBean", new AddBookBean());
		model.addAttribute("authors", bookLibraryService.getAuthors());
		return "addbook";
	}
	
	@RequestMapping("/addbook")
	public String addBook(@ModelAttribute("addBookBean") AddBookBean addBookBean, Model model) {
		Author author = bookLibraryService.getAuthor(addBookBean.getAuthorId());
		if (author.isNotValid()) {
			// TODO inform user of error			
			System.out.println(author.getContext());
			return addBooks(model);
		}
		
		Book book = bookLibraryService.addBook(addBookBean.getBookTitle(), author);
		if (book.isNotValid()) {
			// TODO inform user of error			
			System.out.println(book.getContext());
			return addBooks(model);
		} else {
			return addBooks(model);
		}
	}

	@RequestMapping(value="/editlibrary", params="addabooktolibrary", method=RequestMethod.GET)
	public String addBooksToLibrary(Model model) {
		model.addAttribute("addBookToLibraryBean", new AddBookToLibraryBean());
		model.addAttribute("books", bookLibraryService.getBooks());
		return "addbooktolibrary";
	}
	
	@RequestMapping("/addbooktolibrary")
	public String addBookToLibrary(@ModelAttribute("addBookToLibraryBean")		
			AddBookToLibraryBean addBookToLibraryBean, Model model) {
		
		Authentication authentication = 
			SecurityContextHolder.getContext().getAuthentication();
		bookLibraryService.addBookToLibrary(
				authentication.getName(), addBookToLibraryBean.getBookId());
		return "redirect:library";
	}

	@RequestMapping(value="/editlibrary", params="removebooksfromlibrary", method=RequestMethod.GET)
	public String deleteBooksFromLibrary(
			@RequestParam(value = "selectedBookIds", required = false) int[] selectedBookIds,
			Model model) {
		
		Authentication authentication = 
			SecurityContextHolder.getContext().getAuthentication();
		bookLibraryService.deleteBooksFromLibrary(
				authentication.getName(), selectedBookIds);
		
		return "redirect:library";
	}
	
}

