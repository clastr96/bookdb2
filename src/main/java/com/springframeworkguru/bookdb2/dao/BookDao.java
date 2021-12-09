package com.springframeworkguru.bookdb2.dao;

import com.springframeworkguru.bookdb2.domain.Book;

public interface BookDao {
    Book getById(Long id);
    Book getByTitle(String clean_code);
    Book saveNewBook(Book book);
    Book updateBook(Book saved);
    void deleteBookById(Long id);
}
