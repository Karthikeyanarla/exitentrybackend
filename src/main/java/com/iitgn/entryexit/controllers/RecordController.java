package com.iitgn.entryexit.controllers;

import com.iitgn.entryexit.entities.User;
import com.iitgn.entryexit.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class RecordController {


    private UserRepository userRepository;

    @GetMapping("/record")
    public ResponseEntity<String> getRecords(){
        return new ResponseEntity<String>("Karthikeya", HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<User> getUsers(){
        Optional<User> user = userRepository.findByEmail("karthikeyas1019@gmail.com");

        if(user.isPresent()){
            User user1 = user.get();
            return new ResponseEntity<>(user1, HttpStatus.OK);
        }
        return null;
    }
}
