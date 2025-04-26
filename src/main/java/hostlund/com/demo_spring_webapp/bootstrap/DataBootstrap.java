package hostlund.com.demo_spring_webapp.bootstrap;

import hostlund.com.demo_spring_webapp.domain.Author;
import hostlund.com.demo_spring_webapp.domain.Book;
import hostlund.com.demo_spring_webapp.repositories.AuthorRepository;
import hostlund.com.demo_spring_webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements CommandLineRunner {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;

  public DataBootstrap(BookRepository bookRepository, AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author arthur = new Author();
    arthur.setName("Arthur Conan Doyle");
    Author arthurSaved = authorRepository.save(arthur);

    Book hound = new Book();
    hound.setTitle("The Hound of the Baskervilles");
    hound.setIsbn("1111");

    Book sherlock = new Book();
    hound.setTitle("The Adventures of Sherlock Holmes");
    hound.setIsbn("2222");

    arthurSaved.getBooks().add(bookRepository.save(hound));
    arthurSaved.getBooks().add(bookRepository.save(sherlock));

    System.out.println("In bootstrap");
    System.out.println("Author Count: " + authorRepository.count());
    System.out.println("Book Count: " + bookRepository.count());

  }
}
