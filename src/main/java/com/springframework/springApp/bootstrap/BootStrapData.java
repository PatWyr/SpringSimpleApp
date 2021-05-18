package com.springframework.springApp.bootstrap;

import com.springframework.springApp.domain.Author;
import com.springframework.springApp.domain.Book;
import com.springframework.springApp.repositories.AuthorRepositiory;
import com.springframework.springApp.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositiory authorRepositiory;
    private final BookRepository bookRepository;


    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book book = new Book("Domain Driven Design","123");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        authorRepositiory.save(eric);
        bookRepository.save(book);
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE","1234");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepositiory.save(rod);
        bookRepository.save(noEJB);
        System.out.println("Started in Bootstrap");
        System.out.println("Number of book repo: "+ bookRepository.count());
    }
}
