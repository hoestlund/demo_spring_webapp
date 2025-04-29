package hostlund.com.demo_spring_webapp.controller;

import hostlund.com.demo_spring_webapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @RequestMapping("/authors")
  public String getAuthors(Model model){
    model.addAttribute("authors",authorService.findAll());
    return "books";
  }

  //TODO see what I could do to return one specific book
  // Would involve the service and getting everything after the book/*
  @RequestMapping("/book/")
  public String getAuthor(Model model) {
    //TODO how do I pass the attribute and use this for the service
    //TODO read up on the Model and what it is capable of
    return "book";
  }

}
