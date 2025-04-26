package hostlund.com.demo_spring_webapp.bootstrap;

import hostlund.com.demo_spring_webapp.domain.Author;
import hostlund.com.demo_spring_webapp.domain.Book;
import hostlund.com.demo_spring_webapp.repositories.AuthorRepository;
import hostlund.com.demo_spring_webapp.repositories.BookRepository;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    createArthurWithTwoBooks();
    createTwoAuthorsSameBook();


    System.out.println("Author Count: " + authorRepository.count());
    authorRepository.findAll().forEach(a -> System.out.println(a));

    System.out.println("Book Count: " + bookRepository.count());
    bookRepository.findAll().forEach(b -> System.out.println(b));
  }

  private void createTwoAuthorsSameBook() {
    Author andrew = new Author("Andrew Hunt");
    andrew = authorRepository.save(andrew);

    Author david = new Author("David Hunt");
    david = authorRepository.save(david);

    // TODO check what happens if they are not saved entities but they are added to the book
    //  (which is then saved)
    Book pragmatic = bookRepository.save(new Book("The Pragmatic Programmer","99999",
        Stream.of(andrew,david).collect(
        Collectors.toSet())));

    // The mapping is (currently) not both ways, adding author to a book does not add the book to
    // the author
   // andrew.getBooks().add(pragmatic);
    //authorRepository.save(andrew);

    //david.getBooks().add(pragmatic);
    //authorRepository.save(david);
  }

  private void createArthurWithTwoBooks() {
    Author arthur = new Author();
    arthur.setName("Arthur Conan Doyle");
    Author arthurSaved = authorRepository.save(arthur);

    Book hound = new Book();
    hound.setTitle("The Hound of the Baskervilles");
    hound.setIsbn("1111");
    hound = bookRepository.save(hound);
    arthurSaved.getBooks().add(hound);
    arthurSaved = authorRepository.save(arthur);

    //The author was empty even when the books had been added to the author
    //hound.getAuthors().add(arthurSaved);
    //bookRepository.save(hound);
    //sherlock.getAuthors().add(arthurSaved);
    //bookRepository.save(sherlock);

    // The comment above is also why I believe this step is failing:
    //Unique index or primary key violation: "PUBLIC.PRIMARY_KEY_E ON PUBLIC.AUTHOR_BOOKS
//    Book sherlock = new Book();
//    sherlock.setTitle("The Adventures of Sherlock Holmes");
//    sherlock.setIsbn("2222");
//    sherlock = bookRepository.save(sherlock);
//    arthurSaved.getBooks().add(sherlock);
//    arthurSaved = authorRepository.save(arthur);

  }
}
