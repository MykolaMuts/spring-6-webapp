package project.udemy.springframework.spring6webapp.service;

import org.springframework.stereotype.Service;
import project.udemy.springframework.spring6webapp.entity.Author;
import project.udemy.springframework.spring6webapp.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    public final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
