package com.springframework.springApp.repositories;

import com.springframework.springApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositiory extends CrudRepository<Author,Long> {
}
