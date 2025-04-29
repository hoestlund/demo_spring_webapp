package hostlund.com.demo_spring_webapp.services;

import hostlund.com.demo_spring_webapp.domain.Author;
import hostlund.com.demo_spring_webapp.repositories.AuthorRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{

  private final AuthorRepository authorRepository;

  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public Iterable<Author> findAll() {
    return authorRepository.findAll();
  }

  @Override
  public Optional<Author> findBook(String authorName) {
    //TODO implement repository
    return Optional.empty();
  }
}
