package project.udemy.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.udemy.springframework.spring6webapp.entity.Author;
import project.udemy.springframework.spring6webapp.entity.Book;
import project.udemy.springframework.spring6webapp.entity.Publisher;
import project.udemy.springframework.spring6webapp.repositories.AuthorRepository;
import project.udemy.springframework.spring6webapp.repositories.BookRepository;
import project.udemy.springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        // Assigment 1

        Publisher goodBookPublisher = new Publisher();

        goodBookPublisher.setPublisherName("Good Book Records");
        goodBookPublisher.setCity("LA");
        goodBookPublisher.setState("California");
        goodBookPublisher.setAddress("Kanye West house");
        goodBookPublisher.setZip("808");

        Publisher rocNationPublisher = new Publisher();

        rocNationPublisher.setPublisherName("Roc Nation");
        rocNationPublisher.setCity("New York");
        rocNationPublisher.setState("New York State");
        rocNationPublisher.setAddress("New York city hall");
        rocNationPublisher.setZip("1696");

        Publisher goodBookPublisherSaved = publisherRepository.save(goodBookPublisher);
        Publisher rocNationPublisherSaved = publisherRepository.save(rocNationPublisher);

        // Set Publisher to Book
        ruleBookSaved.setPublisher(rocNationPublisherSaved);
        noEJBSaved.setPublisher(goodBookPublisherSaved);
        dddSaved.setPublisher(goodBookPublisherSaved);

        // Add book to publisher
        rocNationPublisherSaved.getBooks().add(ruleBookSaved);
        goodBookPublisherSaved.getBooks().add(noEJBSaved);
        goodBookPublisherSaved.getBooks().add(dddSaved);

        // Set book to author
        johnSaved.getBooks().add(ruleBookSaved);
        rodSaved.getBooks().add(noEJBSaved);
        ericSaved.getBooks().add(dddSaved);


        // Add author to book
        ruleBookSaved.getAuthors().add(johnSaved);
        noEJBSaved.getAuthors().add(rodSaved);
        dddSaved.getAuthors().add(ericSaved);

        // Save it
        publisherRepository.save(goodBookPublisherSaved);
        publisherRepository.save(rocNationPublisherSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(ruleBookSaved);
        authorRepository.save(johnSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
