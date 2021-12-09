package com.springframeworkguru.bookdb2.dao;

import com.springframeworkguru.bookdb2.domain.Author;

public interface AuthorDao {
    Author getById(Long id);
    Author getByName(String firstName, String lastName);
    Author saveNewAuthor(Author author);
    Author updateAuthor(Author saved);
    void deleteAuthorById(Long id);
}
