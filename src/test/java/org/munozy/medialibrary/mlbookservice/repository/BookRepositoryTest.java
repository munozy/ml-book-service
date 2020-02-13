package org.munozy.medialibrary.mlbookservice.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.munozy.medialibrary.mlbookservice.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = "classpath:dataset/dataset-book.sql")
    public void findFirstBookByTitlePerAuthor_should_return_four_books() {
        String title = "pla";
        List<Book> bookList = bookRepository.findBookByTitleLike(title);

        assertThat(bookList).hasSize(6);
        assertThat(bookList.get(0).getTitle().toLowerCase()).contains(title);
        assertThat(bookList.get(1).getTitle().toLowerCase()).contains(title);
        assertThat(bookList.get(2).getTitle().toLowerCase()).contains(title);
        assertThat(bookList.get(3).getTitle().toLowerCase()).contains(title);
        assertThat(bookList.get(4).getTitle().toLowerCase()).contains(title);
        assertThat(bookList.get(5).getTitle().toLowerCase()).contains(title);
    }
}