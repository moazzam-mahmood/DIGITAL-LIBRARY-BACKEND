package org.myprojects.DIGITAL_LIBRARY.mappers.input;

import org.myprojects.DIGITAL_LIBRARY.entities.input.BookInputEntity;
import org.myprojects.DIGITAL_LIBRARY.models.BookModel;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class BookInputMapper {

    public BookModel mapToModel(BookInputEntity bookInputEntity) {
        return BookModel.builder()
                .id(bookInputEntity.getId())
                .author(bookInputEntity.getAuthor())
                .name(bookInputEntity.getName())
                .description(bookInputEntity.getDescription())
                .author(bookInputEntity.getAuthor())
                .publishedDate(bookInputEntity.getPublishedDate())
                .createdAt(Instant.now())
                .build();
    }
}
