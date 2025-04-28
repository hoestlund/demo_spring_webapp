package hostlund.com.demo_spring_webapp.bootstrap;

import hostlund.com.demo_spring_webapp.domain.Author;
import hostlund.com.demo_spring_webapp.domain.Book;
import hostlund.com.demo_spring_webapp.domain.Publisher;
import hostlund.com.demo_spring_webapp.repositories.AuthorRepository;
import hostlund.com.demo_spring_webapp.repositories.BookRepository;
import hostlund.com.demo_spring_webapp.repositories.PublisherRepository;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements CommandLineRunner {

  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final PublisherRepository publisherRepository;

  public DataBootstrap(BookRepository bookRepository, AuthorRepository authorRepository,
      PublisherRepository publisherRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) {
    createArthurWithTwoBooks();
    createTwoAuthorsSameBook();

    createPublisher();
  }

  private void createPublisher() {
    Publisher publisher = new Publisher("O'Reilly Media", "Sebastopol, CA, USA");

    Book dataIntensive = bookRepository.save(new Book("Designing Data-Intensive Applications",
        "55555"));
    Author martin = authorRepository.save(new Author("Martin Kleppmann"));

    dataIntensive.getAuthors().add(martin);
    dataIntensive = bookRepository.save(dataIntensive);

    publisher.getPublishedTitles().add(dataIntensive);
    publisherRepository.save(publisher);

    dataIntensive.setPublisher(publisher);
    bookRepository.save(dataIntensive);
  }

  private void createTwoAuthorsSameBook() {
    Author andrew = new Author("Andrew Hunt");
    andrew = authorRepository.save(andrew);

    Author david = new Author("David Thomas");
    david = authorRepository.save(david);


    Book pragmatic = bookRepository.save(new Book("The Pragmatic Programmer", "99999",
        Stream.of(andrew, david).collect(
            Collectors.toSet())));

    andrew.getBooks().add(pragmatic);
    authorRepository.save(andrew);

    david.getBooks().add(pragmatic);
    authorRepository.save(david);

    Publisher publisher = new Publisher("Addison-Wesley Longman", "Amsterdam, Netherlands");
    publisher = publisherRepository.save(publisher);
    publisher.getPublishedTitles().add(pragmatic);

    pragmatic.setPublisher(publisher);
    bookRepository.save(pragmatic);
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

    Publisher publisher = new Publisher("Harper & Brother", "NYC, NY, USA");
    publisher = publisherRepository.save(publisher);
    publisher.getPublishedTitles().add(hound);

    hound.setPublisher(publisher);
    bookRepository.save(hound);

//TODO add
    //Unique index or primary key violation: "PUBLIC.PRIMARY_KEY_E ON PUBLIC.AUTHOR_BOOKS
//   Book sherlock = new Book();
//    sherlock.setTitle("The Adventures of Sherlock Holmes");
//    sherlock.setIsbn("2222");
//    sherlock.getAuthors().add(arthurSaved);
//    sherlock = bookRepository.save(sherlock);
//    arthurSaved.getBooks().add(sherlock);
//    arthurSaved = authorRepository.save(arthur);

  }
}
