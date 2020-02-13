package org.munozy.medialibrary.mlbookservice.mapper;

import org.mapstruct.Mapper;
import org.munozy.medialibrary.mlbookservice.domain.Book;
import org.munozy.medialibrary.mlbookservice.dto.BookDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookDto bookDto);

    BookDto toBookDto(Book book);

    List<Book> toBookList(List<BookDto> bookDtoList);

    List<BookDto> toBookDtoList(List<Book> bookList);

}
