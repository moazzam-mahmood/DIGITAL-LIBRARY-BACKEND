package org.myprojects.DIGITAL_LIBRARY.mappers.output;

import org.myprojects.DIGITAL_LIBRARY.entities.output.BookOutputEntity;
import org.myprojects.DIGITAL_LIBRARY.models.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookOutputMapper {

    public BookModel mapToModel(BookOutputEntity bookOutputEntity) {
        return BookModel.builder()
                .id(bookOutputEntity.getId())
                .name(bookOutputEntity.getName())
                .author(bookOutputEntity.getAuthor())
                .description(bookOutputEntity.getDescription())
                .publishedDate(bookOutputEntity.getPublishedDate())
                .createdAt(bookOutputEntity.getCreatedAt())
                .updatedAt(bookOutputEntity.getUpdatedAt())
                .build();
    }

    public BookOutputEntity mapFromModel(BookModel bookModel) {
        return BookOutputEntity.builder()
                .id(bookModel.getId())
                .name(bookModel.getName())
                .author(bookModel.getAuthor())
                .description(bookModel.getDescription())
                .publishedDate(bookModel.getPublishedDate())
                .createdAt(bookModel.getCreatedAt())
                .updatedAt(bookModel.getUpdatedAt())
                .build();
    }
}
