package org.munozy.medialibrary.mlbookservice.repository;

import org.munozy.medialibrary.mlbookservice.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where LOWER(b.title) like %:title% order by b.author, b.title")
    List<Book> findBookByTitleLike(String title);
}
