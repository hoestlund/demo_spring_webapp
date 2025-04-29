package hostlund.com.demo_spring_webapp.services;

import hostlund.com.demo_spring_webapp.domain.Author;
import java.util.Optional;

public interface AuthorService {

  Iterable<Author> findAll();

  Optional<Author> findBook(String authorName);

}
