package com.springframeworkguru.bookdb2;

import com.springframeworkguru.bookdb2.dao.BookDao;
import com.springframeworkguru.bookdb2.domain.Author;
import com.springframeworkguru.bookdb2.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = {"com.springframeworkguru.bookdb2.dao"})
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookDaoIntegrationTest {
    @Autowired
    BookDao bookDao;


    @Test
    void testGetBook() {
        Book book = bookDao.getById(1L);
        assertThat(book).isNotNull();
    }

    @Test
    void testGetBookByTitle() {
        Book book = bookDao.getByTitle("Clean Code");
        assertThat(book).isNotNull();
    }

    @Test
    void testSaveBook() {
        Book book = new Book();
        book.setTitle("LOL");
        book.setIsbn("LOL1");
        book.setPublisher("LMAO");

        Book saved = bookDao.saveNewBook(book);
        assertThat(saved).isNotNull();
    }

    @Test
    void testUpdateBook() {
        Book book = new Book();
        book.setTitle("Johny");
        book.setIsbn("yt");
        book.setPublisher("yta");

        Author author = new Author();
        author.setId(3L);

        book.setAuthor(author);

        Book saved = bookDao.saveNewBook(book);

        saved.setIsbn("123456");
        Book updated = bookDao.updateBook(saved);

        assertThat(updated.getIsbn()).isEqualTo("123456");
    }

    @Test
    void testDeleteBook() {
        Book book = new Book();
        book.setTitle("Johny");
        book.setIsbn("yt");
        book.setPublisher("yta");

        Author author = new Author();
        author.setId(3L);

        book.setAuthor(author);

        Book saved = bookDao.saveNewBook(book);
        bookDao.deleteBookById(saved.getId());

        Book deleted = bookDao.getById(saved.getId());

        assertThat(deleted).isNull();
    }
}
