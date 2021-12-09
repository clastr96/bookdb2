package com.springframeworkguru.bookdb2;

import com.springframeworkguru.bookdb2.dao.AuthorDao;
import com.springframeworkguru.bookdb2.domain.Author;
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
public class AuthorDaoIntegrationTest {

    @Autowired
    AuthorDao authorDao;

    @Test
    void testGetAuthor() {
        Author author = authorDao.getById(1L);
        assertThat(author).isNotNull();
    }

    @Test
    void testGetAuthorByName() {
        Author author = authorDao.getByName("Craig", "Walls");
        assertThat(author).isNotNull();
    }

    @Test
    void testSaveAuthor() {
        Author author = new Author();
        author.setFirstName("Radek");
        author.setLastName("Provaz");
        Author saved = authorDao.saveNewAuthor(author);

        assertThat(saved).isNotNull();
    }

    @Test
    void testUpdateAuthor() {
        Author author = new Author();
        author.setFirstName("Johny");
        author.setLastName("yt");

        Author saved = authorDao.saveNewAuthor(author);

        saved.setLastName("Tommy");
        Author updated = authorDao.updateAuthor(saved);

        assertThat(updated.getLastName()).isEqualTo("Tommy");
    }

    @Test
    void testDeleteAuthor() {
        Author author = new Author();
        author.setFirstName("Hon");
        author.setLastName("Shun");

        Author saved = authorDao.saveNewAuthor(author);
        authorDao.deleteAuthorById(saved.getId());

        Author deleted = authorDao.getById(saved.getId());

        assertThat(deleted).isNull();
    }
}
