package hostlund.com.demo_spring_webapp.repositories;

import hostlund.com.demo_spring_webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {

}
