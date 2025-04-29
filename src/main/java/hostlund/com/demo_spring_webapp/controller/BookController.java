package hostlund.com.demo_spring_webapp.controller;

import hostlund.com.demo_spring_webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }
  @RequestMapping("/books")
  public String getBook(Model model) {
    model.addAttribute("books",bookService.findAll());

    //Will be returned when the view is built
    return "books";
  }
}
