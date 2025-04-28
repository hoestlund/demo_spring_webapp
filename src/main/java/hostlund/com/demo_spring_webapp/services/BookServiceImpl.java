package hostlund.com.demo_spring_webapp.services;

import hostlund.com.demo_spring_webapp.domain.Book;
import hostlund.com.demo_spring_webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Iterable<Book> findAll() {
    return bookRepository.findAll();
  }
}
