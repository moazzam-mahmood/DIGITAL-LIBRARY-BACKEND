package org.myprojects.DIGITAL_LIBRARY.mappers.output;

import org.apache.catalina.User;
import org.myprojects.DIGITAL_LIBRARY.entities.output.UserOutputEntity;
import org.myprojects.DIGITAL_LIBRARY.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserOutputMapper {

    public UserModel mapToModel(UserOutputEntity userOutputEntity) {
        return UserModel.builder()
                .id(userOutputEntity.getId())
                .email(userOutputEntity.getEmail())
                .firstName(userOutputEntity.getFirstName())
                .lastName(userOutputEntity.getLastName())
                .phone(userOutputEntity.getPhone())
                .dateOfBirth(userOutputEntity.getDateOfBirth())
                .build();
    }

    public UserOutputEntity mapFromModel(UserModel userModel) {
        return UserOutputEntity.builder()
                .id(userModel.getId())
                .email(userModel.getEmail())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .phone(userModel.getPhone())
                .dateOfBirth(userModel.getDateOfBirth())
                .build();
    }
}
