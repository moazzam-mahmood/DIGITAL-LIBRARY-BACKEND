package org.myprojects.DIGITAL_LIBRARY.repository;

import org.myprojects.DIGITAL_LIBRARY.entities.output.BookOutputEntity;
import org.myprojects.DIGITAL_LIBRARY.mappers.output.BookOutputMapper;
import org.myprojects.DIGITAL_LIBRARY.models.BookModel;
import org.myprojects.DIGITAL_LIBRARY.repository.jpa.BookJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class BookRepository {

    private final BookJPARepository bookJPARepository;
    private final BookOutputMapper bookOutputMapper;

    //Constructor Injection
    @Autowired
    public BookRepository(BookJPARepository bookJPARepository, BookOutputMapper bookOutputMapper ) {
        this.bookJPARepository = bookJPARepository;
        this.bookOutputMapper = bookOutputMapper;
    }

    public BookModel save(BookModel bookModel) {
        //convert model to output entity
        //save in DB
        //convert back the outputEntity to model
        //return model

        BookOutputEntity bookOutputEntity = this.bookOutputMapper.mapFromModel(bookModel);
        BookOutputEntity saved = this.bookJPARepository.save(bookOutputEntity);
        return this.bookOutputMapper.mapToModel(saved);
    }

    public ResponseEntity<BookModel> findById(long id) {
        Optional<BookOutputEntity> optionalBookOutputEntity = this.bookJPARepository.findById(id);
        if(optionalBookOutputEntity.isPresent()) {
            BookOutputEntity bookOutputEntity = optionalBookOutputEntity.get();
            BookModel bookModel = this.bookOutputMapper.mapToModel(bookOutputEntity);
            return new ResponseEntity<>(bookModel, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<BookModel> deleteById(long id) {
        if (this.bookJPARepository.existsById(id)) {
            this.bookJPARepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<BookModel> updateById(long id, BookModel bookModel) {
        Optional<BookOutputEntity> optionalBookOutputEntity = this.bookJPARepository.findById(id);
        if (optionalBookOutputEntity.isPresent()) {
            //get the book output entity
            BookOutputEntity bookOutputEntity = optionalBookOutputEntity.get();
            //apply the changes
            if (bookModel.getName() != null) {
                bookOutputEntity.setName(bookModel.getName());
            }
            if (bookModel.getAuthor() != null) {
                bookOutputEntity.setAuthor(bookModel.getAuthor());
            }
            if (bookModel.getDescription() != null) {
                bookOutputEntity.setDescription(bookModel.getDescription());
            }
            bookOutputEntity.setUpdatedAt(Instant.now());
            //save into db
            BookOutputEntity saved = this.bookJPARepository.save(bookOutputEntity);
            //return back update book model within ResponseEntity
            BookModel savedBook = this.bookOutputMapper.mapToModel(saved);
            return new ResponseEntity<>(savedBook, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
