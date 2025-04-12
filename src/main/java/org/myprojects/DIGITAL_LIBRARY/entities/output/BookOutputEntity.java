package org.myprojects.DIGITAL_LIBRARY.entities.output;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Builder
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class BookOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "author", length = 50, nullable = false)
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "published_at")
    private Instant publishedDate;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;
}
