package org.myprojects.DIGITAL_LIBRARY.entities.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class BookInputEntity {

    //Takes input from user(only those parameters which are exposed to user)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Author is mandatory")
    private String author;

    private String description;

    @NotNull(message = "Published date is mandatory")
    private Instant publishedDate;
}
