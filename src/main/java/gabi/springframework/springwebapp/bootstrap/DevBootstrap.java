package gabi.springframework.springwebapp.bootstrap;

import gabi.springframework.springwebapp.model.Author;
import gabi.springframework.springwebapp.model.Book;
import gabi.springframework.springwebapp.model.Publisher;
import gabi.springframework.springwebapp.repositories.AuthorRepository;
import gabi.springframework.springwebapp.repositories.BookRepository;
import gabi.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){
        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJ8 = new Book("J2EE Development without EJ8", "2342", publisher);
        eric.getBooks().add(noEJ8);

        authorRepository.save(rod);
        bookRepository.save(noEJ8);

    }
}
