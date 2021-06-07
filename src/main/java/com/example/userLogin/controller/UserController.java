package com.example.userLogin.controller;

import com.example.userLogin.entity.UserEntity;
import com.example.userLogin.repository.UserRepository;
import com.example.userLogin.request.LoginRequest;
import com.example.userLogin.request.UserRequest;
import com.example.userLogin.response.PortalResponse;
import com.example.userLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/saveInfo")
    public PortalResponse saveInfo(@RequestBody @Valid UserRequest req){
        return service.saveInfo(req);
    }

    @PostMapping("/login")
    public PortalResponse login(@RequestBody LoginRequest req){
        return service.login(req);
    }

    @GetMapping("/fetchAllRecords")
    public List<UserEntity> fetch(){
        return service.fetch();
    }
}
