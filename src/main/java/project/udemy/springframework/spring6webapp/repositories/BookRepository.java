package project.udemy.springframework.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import project.udemy.springframework.spring6webapp.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
