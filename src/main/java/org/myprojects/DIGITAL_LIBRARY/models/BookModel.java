package org.myprojects.DIGITAL_LIBRARY.models;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.Instant;

@Data  // getters, setters, toString, equals, hashCode automatically generated
@Builder //Useful when you have many fields or optional fields and want to avoid long constructors.
@With //generates "with" methods that create a copy of the current object, with one field modified.
public class BookModel {

    private long id;
    private String name;
    private String author;
    private String description;
    private Instant publishedDate;
    private Instant createdAt;
    private Instant updatedAt;
}
