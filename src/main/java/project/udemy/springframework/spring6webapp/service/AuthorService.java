package project.udemy.springframework.spring6webapp.service;

import project.udemy.springframework.spring6webapp.entity.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
