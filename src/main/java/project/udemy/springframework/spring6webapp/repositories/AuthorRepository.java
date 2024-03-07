package project.udemy.springframework.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import project.udemy.springframework.spring6webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
