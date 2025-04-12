package org.myprojects.DIGITAL_LIBRARY.models;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.Instant;

@Data
@Builder
@With
public class UserModel {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Instant dateOfBirth;

}
