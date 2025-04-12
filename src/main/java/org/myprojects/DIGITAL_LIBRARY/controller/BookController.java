package org.myprojects.DIGITAL_LIBRARY.controller;

import jakarta.validation.Valid;
import org.myprojects.DIGITAL_LIBRARY.adapter.BookAdapter;
import org.myprojects.DIGITAL_LIBRARY.entities.input.BookInputEntity;
import org.myprojects.DIGITAL_LIBRARY.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book-library")
public class BookController {

    private final BookAdapter bookAdapter;
    private final BookService bookService;

    @Autowired
    public BookController(BookAdapter bookAdapter, BookService bookService) {
        this.bookAdapter = bookAdapter;
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookInputEntity book) {
        return new ResponseEntity<>(
                this.bookAdapter.save(book),
                HttpStatus.CREATED
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBookById(@PathVariable long id) {
        return this.bookService.getBookById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable long id) {
        return this.bookService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody BookInputEntity book) {
        return this.bookAdapter.updateBook(id, book);
    }


}
