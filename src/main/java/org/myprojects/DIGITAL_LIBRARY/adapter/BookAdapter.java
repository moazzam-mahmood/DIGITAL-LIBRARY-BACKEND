package org.myprojects.DIGITAL_LIBRARY.adapter;

import org.myprojects.DIGITAL_LIBRARY.entities.input.BookInputEntity;
import org.myprojects.DIGITAL_LIBRARY.mappers.input.BookInputMapper;
import org.myprojects.DIGITAL_LIBRARY.models.BookModel;
import org.myprojects.DIGITAL_LIBRARY.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BookAdapter {

    private final BookInputMapper bookInputMapper;
    private final BookService bookService;

    @Autowired
    public BookAdapter(BookInputMapper bookInputMapper, BookService bookService) {
        this.bookInputMapper = bookInputMapper;
        this.bookService = bookService;
    }

    public BookModel save(BookInputEntity inputEntity){
        return this.bookService.addBook(
                this.bookInputMapper.mapToModel(inputEntity)
        );
    }

    public ResponseEntity<?> updateBook(long id, BookInputEntity inputEntity) {
        return this.bookService.updateBook(id,
                this.bookInputMapper.mapToModel(inputEntity));
    }
}
