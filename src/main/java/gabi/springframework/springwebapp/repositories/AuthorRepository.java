package gabi.springframework.springwebapp.repositories;

import gabi.springframework.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
