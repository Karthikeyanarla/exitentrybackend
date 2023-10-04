package com.iitgn.entryexit.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecordController {

    @GetMapping("/record")
    public ResponseEntity<String> getRecords(){
        return new ResponseEntity<String>("Karthikeya", HttpStatus.OK);
    }
}
