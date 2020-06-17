package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.models.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public bootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher("Altenberg","wisniowa 12/1","Wrocław","Slonsk","69-420");

        publisherRepository.save(publisher1);



        Book book1 = new Book("pierwszaKsiazka","12312313");
        Book book2 = new Book("Druga Ksiazka","56565656");

        Author author1 = new Author("kazek","ktos");
        Author author2 = new Author("kupa","Brakneta");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);


        authorRepository.save(author1);
        bookRepository.save(book1);

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book2);


        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books" + bookRepository.count());
        System.out.println("Number of books in publisher" + publisher1.getBooks().size());


        System.out.println(publisherRepository.findAll().iterator().next().toString());

    }
}
