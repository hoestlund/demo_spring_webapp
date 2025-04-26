package hostlund.com.demo_spring_webapp.repositories;

import hostlund.com.demo_spring_webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {

}
