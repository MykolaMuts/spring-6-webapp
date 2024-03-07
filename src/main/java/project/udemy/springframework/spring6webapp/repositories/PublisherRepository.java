package project.udemy.springframework.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import project.udemy.springframework.spring6webapp.entity.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
