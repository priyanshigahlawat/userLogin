package com.example.userLogin.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserRequest {

    @NotNull(message = "name cannot be null")
    private String id;

    private int age;

    private String pass;

}
