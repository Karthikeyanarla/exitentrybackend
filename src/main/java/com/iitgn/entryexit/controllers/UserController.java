package com.iitgn.entryexit.controllers;


import com.iitgn.entryexit.entities.User;
import com.iitgn.entryexit.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import  java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @PostMapping("/api/users/{id}")
//    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) {
//        return userService.updateUserById(id, user).map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }


    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> changeNameById(@PathVariable Long id, @RequestBody String name) {
        userService.changeNameById(id, name);
        return userService.getUserById(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @PutMapping("/api/users/{id}")
//    public ResponseEntity<User> changePasswordById(@PathVariable Long id, @RequestBody String password) {
//        // encode the password using bcrypt
//
//        User user = userService.getUserById(id).orElse(null);
//        String encodedPassword = "";
//        if(user != null){
//            encodedPassword = passwordEncoder.encode(password);
//        }
//        return userService.changePasswordById(id, encodedPassword).map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }



}

















