package com.springframework.springApp.bootstrap;

import com.springframework.springApp.domain.Author;
import com.springframework.springApp.domain.Book;
import com.springframework.springApp.domain.Publisher;
import com.springframework.springApp.repositories.AuthorRepositiory;
import com.springframework.springApp.repositories.BookRepository;
import com.springframework.springApp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositiory authorRepositiory;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        Publisher publisher = new Publisher();
        publisher.setAddress("Kwarcowa");
        publisher.setCity("Warsaw");
        publisher.setState("Cos");
        publisher.setZip(123);
        publisherRepository.save(publisher);
        Author eric = new Author("Eric","Evans");
        Book book = new Book("Domain Driven Design","123");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        authorRepositiory.save(eric);
        bookRepository.save(book);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE","1234");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepositiory.save(rod);
        bookRepository.save(noEJB);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of books repo: "+ bookRepository.count());
        System.out.println("Publisher in repo : "+publisherRepository.count());
        System.out.println("Publisher books : "+publisher.getBooks().size());
    }
}
