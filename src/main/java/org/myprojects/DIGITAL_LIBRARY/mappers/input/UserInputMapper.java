package org.myprojects.DIGITAL_LIBRARY.mappers.input;

import org.myprojects.DIGITAL_LIBRARY.entities.input.UserInputEntity;
import org.myprojects.DIGITAL_LIBRARY.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserInputMapper {

    public UserModel mapToModel(UserInputEntity userInputEntity) {
        return UserModel.builder()
                .id(userInputEntity.getId())
                .firstName(userInputEntity.getFirstName())
                .lastName(userInputEntity.getLastName())
                .phone(userInputEntity.getPhone())
                .dateOfBirth(userInputEntity.getDateOfBirth())
                .email(userInputEntity.getEmail())
                .build();
    }
}
