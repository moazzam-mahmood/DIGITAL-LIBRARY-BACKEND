package org.myprojects.DIGITAL_LIBRARY.service;

import org.myprojects.DIGITAL_LIBRARY.models.BookModel;
import org.myprojects.DIGITAL_LIBRARY.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookModel addBook(BookModel bookModel) {
        return this.bookRepository.save(bookModel);
    }

    public ResponseEntity<?> getBookById(long id) {
        return this.bookRepository.findById(id);
    }

    public ResponseEntity<?> deleteById(long id) {
        return this.bookRepository.deleteById(id);
    }

    public ResponseEntity<?> updateBook(long id, BookModel bookModel) {
        return this.bookRepository.updateById(id,bookModel);
    }

    public ResponseEntity<?> listAllBooks() {
        return this.bookRepository.findAllBooks();
    }
}
