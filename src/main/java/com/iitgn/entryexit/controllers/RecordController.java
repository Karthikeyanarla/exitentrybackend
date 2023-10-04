package com.iitgn.entryexit.controllers;

import com.iitgn.entryexit.entities.User;
import com.iitgn.entryexit.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RecordController {


    private final UserRepository userRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/record")
    public ResponseEntity<String> getRecords(){
        return new ResponseEntity<String>("Karthikeya", HttpStatus.OK);
    }
}
