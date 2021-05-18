package com.springframework.springApp.repositories;

import com.springframework.springApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
