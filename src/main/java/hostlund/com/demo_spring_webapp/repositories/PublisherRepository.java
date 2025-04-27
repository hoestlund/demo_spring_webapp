package hostlund.com.demo_spring_webapp.repositories;

import hostlund.com.demo_spring_webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
