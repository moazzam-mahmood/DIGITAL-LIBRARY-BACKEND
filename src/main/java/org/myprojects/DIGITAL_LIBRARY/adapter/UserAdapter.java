package org.myprojects.DIGITAL_LIBRARY.adapter;

import org.myprojects.DIGITAL_LIBRARY.entities.input.UserInputEntity;
import org.myprojects.DIGITAL_LIBRARY.mappers.input.UserInputMapper;
import org.myprojects.DIGITAL_LIBRARY.models.UserModel;
import org.myprojects.DIGITAL_LIBRARY.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    private final UserInputMapper userInputMapper;
    private final UserService userService;

    @Autowired
    public UserAdapter(UserInputMapper userInputMapper, UserService userService) {
        this.userInputMapper = userInputMapper;
        this.userService = userService;
    }

    public UserModel save(UserInputEntity userInputEntity){
        return this.userService.saveUser(this.userInputMapper.mapToModel(userInputEntity));
    }

    public ResponseEntity<?> updateUser(long id, UserInputEntity userInputEntity) {
        return this.userService.updateUser(id, this.userInputMapper.mapToModel(userInputEntity));
    }

}
