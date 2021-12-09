package com.springframeworkguru.bookdb2.repository;

import com.springframeworkguru.bookdb2.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
