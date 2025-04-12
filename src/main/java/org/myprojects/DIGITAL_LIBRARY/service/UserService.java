package org.myprojects.DIGITAL_LIBRARY.service;

import org.myprojects.DIGITAL_LIBRARY.models.UserModel;
import org.myprojects.DIGITAL_LIBRARY.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel saveUser(UserModel userModel) {
        return this.userRepository.save(userModel);
    }

    public ResponseEntity<?> deleteById(long id) {
        return this.userRepository.deleteById(id);
    }

    public ResponseEntity<?> getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public ResponseEntity<?> updateUser(long id, UserModel userModel) {
        return this.userRepository.updateById(id, userModel);
    }

}
