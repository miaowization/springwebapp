package gabi.springframework.springwebapp.repositories;

import gabi.springframework.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
