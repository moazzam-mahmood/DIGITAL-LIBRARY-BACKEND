package org.myprojects.DIGITAL_LIBRARY.repository;

import org.myprojects.DIGITAL_LIBRARY.entities.output.UserOutputEntity;
import org.myprojects.DIGITAL_LIBRARY.mappers.output.UserOutputMapper;
import org.myprojects.DIGITAL_LIBRARY.models.UserModel;
import org.myprojects.DIGITAL_LIBRARY.repository.jpa.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepository {

    private final UserJPARepository userJPARepository;
    private final UserOutputMapper userOutputMapper;

    @Autowired
    public UserRepository(UserJPARepository userJPARepository, UserOutputMapper userOutputMapper) {
        this.userJPARepository = userJPARepository;
        this.userOutputMapper = userOutputMapper;
    }

    public UserModel save(UserModel userModel) {
        UserOutputEntity userOutputEntity = this.userOutputMapper.mapFromModel(userModel);
        UserOutputEntity saved = this.userJPARepository.save(userOutputEntity);
        return this.userOutputMapper.mapToModel(saved);
    }

    public ResponseEntity<UserModel> findById(Long id) {
        Optional<UserOutputEntity> optionalUserOutputEntity  =this.userJPARepository.findById(id);
        if(optionalUserOutputEntity.isPresent()){
            UserOutputEntity userOutputEntity = optionalUserOutputEntity.get();
            UserModel userModel = this.userOutputMapper.mapToModel(userOutputEntity);
            return new ResponseEntity<>(userModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> deleteById(Long id) {
        if(this.userJPARepository.existsById(id)){
            this.userJPARepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> updateById(long id, UserModel userModel) {
        Optional<UserOutputEntity> optionalUserOutputEntity  =this.userJPARepository.findById(id);
        if(optionalUserOutputEntity.isPresent()){
            UserOutputEntity userOutputEntity = optionalUserOutputEntity.get();
            if(userModel.getFirstName() != null){
                userOutputEntity.setFirstName(userModel.getFirstName());
            }
            if(userModel.getLastName() != null){
                userOutputEntity.setLastName(userModel.getLastName());
            }
            if(userModel.getEmail() != null){
                userOutputEntity.setEmail(userModel.getEmail());
            }
            if(userModel.getDateOfBirth() != null){
                userOutputEntity.setDateOfBirth(userModel.getDateOfBirth());
            }
            if(userModel.getPhone() != null){
                userOutputEntity.setPhone(userModel.getPhone());
            }

            UserOutputEntity saved = this.userJPARepository.save(userOutputEntity);
            return new ResponseEntity<>(userOutputMapper.mapToModel(saved), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
