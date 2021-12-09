package com.springframeworkguru.bookdb2.repository;

import com.springframeworkguru.bookdb2.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
