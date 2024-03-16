package project.udemy.springframework.spring6webapp.service;

import project.udemy.springframework.spring6webapp.entity.Book;

public interface BookService {

    Iterable<Book> findAll();
}
