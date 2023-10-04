package com.iitgn.entryexit.models;

import lombok.Data;

@Data
public class SignUpDto {
    private String name;
    private String email;
    private String password;
}