package project.udemy.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.udemy.springframework.spring6webapp.domain.Author;
import project.udemy.springframework.spring6webapp.domain.Book;
import project.udemy.springframework.spring6webapp.repositories.AuthorRepository;
import project.udemy.springframework.spring6webapp.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Cyberpunk 2077 easter egg
        Author John = new Author();

        John.setFirstName("John");
        John.setLastName("Phallustiff");

        Book ruleBook = new Book();

        ruleBook.setTitle("Rules of Cyberpunk 2020");
        ruleBook.setIsbn("5325ADF");

        Author johnSaved = authorRepository.save(John);
        Book ruleBookSaved = bookRepository.save(ruleBook);

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        johnSaved.getBookSet().add(dddSaved);
        rodSaved.getBookSet().add(noEJBSaved);

        authorRepository.save(johnSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
