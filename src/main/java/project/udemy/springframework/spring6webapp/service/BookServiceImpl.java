package project.udemy.springframework.spring6webapp.service;

import org.springframework.stereotype.Service;
import project.udemy.springframework.spring6webapp.entity.Book;
import project.udemy.springframework.spring6webapp.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    public final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
