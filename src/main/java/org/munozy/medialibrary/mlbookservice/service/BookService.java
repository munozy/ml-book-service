package org.munozy.medialibrary.mlbookservice.service;

import javassist.NotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.munozy.medialibrary.mlbookservice.domain.Book;
import org.munozy.medialibrary.mlbookservice.dto.BookDto;
import org.munozy.medialibrary.mlbookservice.mapper.BookMapper;
import org.munozy.medialibrary.mlbookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class BookService {
    final BookRepository bookRepository;

    final BookMapper bookMapper;

    public List<BookDto> getBooks() {
        return bookMapper.toBookDtoList(bookRepository.findAll());
    }

    public List<BookDto> getBooksByTitle(String title){
        return bookMapper.toBookDtoList(bookRepository.findBookByTitleLike(title.toLowerCase()));
    }
}
