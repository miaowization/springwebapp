package gabi.springframework.springwebapp.repositories;

import gabi.springframework.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
