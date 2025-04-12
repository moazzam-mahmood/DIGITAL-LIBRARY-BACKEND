package org.myprojects.DIGITAL_LIBRARY.entities.output;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Builder
@Table(name = "app_user")
@NoArgsConstructor
@AllArgsConstructor
public class UserOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name = "date_of_birth")
    private Instant dateOfBirth;

}
