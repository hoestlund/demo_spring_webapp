package hostlund.com.demo_spring_webapp.services;

import hostlund.com.demo_spring_webapp.domain.Book;

public interface BookService {

  Iterable<Book> findAll();

}
