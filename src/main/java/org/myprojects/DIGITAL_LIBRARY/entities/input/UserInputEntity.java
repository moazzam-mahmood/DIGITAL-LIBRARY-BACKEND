package org.myprojects.DIGITAL_LIBRARY.entities.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class UserInputEntity {

    private long id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @NotBlank(message = "email id is mandatory")
    private String email;

    private Instant dateOfBirth;

    private String phone;
}
