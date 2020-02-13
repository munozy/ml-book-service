package org.munozy.medialibrary.mlbookservice.controller;

import javassist.NotFoundException;
import org.munozy.medialibrary.mlbookservice.dto.BookDto;
import org.munozy.medialibrary.mlbookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BookController.PATH)
public class BookController {
    static final String PATH = "/book/v1";

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/")
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/{title}")
    public List<BookDto> getBooksByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

}
