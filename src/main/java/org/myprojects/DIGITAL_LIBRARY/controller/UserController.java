package org.myprojects.DIGITAL_LIBRARY.controller;

import jakarta.validation.Valid;
import org.myprojects.DIGITAL_LIBRARY.adapter.UserAdapter;
import org.myprojects.DIGITAL_LIBRARY.entities.input.UserInputEntity;
import org.myprojects.DIGITAL_LIBRARY.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserAdapter userAdapter;

    @Autowired
    public UserController(UserService userService, UserAdapter userAdapter) {
        this.userService = userService;
        this.userAdapter = userAdapter;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserInputEntity user) {
        return new ResponseEntity<>(this.userAdapter.save(user), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) {
        return this.userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id) {
        return this.userService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody UserInputEntity user) {
        return this.userAdapter.updateUser(id, user);
    }
}
