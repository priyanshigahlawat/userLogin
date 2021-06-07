package com.example.userLogin.service;

import com.example.userLogin.entity.UserEntity;
import com.example.userLogin.repository.UserRepository;
import com.example.userLogin.request.LoginRequest;
import com.example.userLogin.request.UserRequest;
import com.example.userLogin.response.PortalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public PortalResponse saveInfo(@RequestBody @Valid UserRequest req){
        PortalResponse portalResponse = new PortalResponse();
        Optional<UserEntity> userEntity1 = repo.findById(req.getId());
        System.out.println(req.getPass() + " " + req.getId());
        if(userEntity1.isPresent()){
            portalResponse.setMsg("record already exist");
            portalResponse.setStatusCode("202");
        } else{
            UserEntity userEntity = new UserEntity();
            userEntity.setId(req.getId());
            userEntity.setPass(req.getPass());
            userEntity.setAge(req.getAge());
            repo.save(userEntity);
            portalResponse.setMsg("record saved");
            portalResponse.setStatusCode("200");
        }
        return portalResponse;
    }

    public PortalResponse login(@RequestBody LoginRequest req){
        PortalResponse portalResponse = new PortalResponse();
        Optional<UserEntity> userEntity1 = repo.findById(req.getId());
        if(userEntity1.isPresent()){
            portalResponse.setMsg("Login successful");
            portalResponse.setStatusCode("200");
        } else{
            portalResponse.setMsg("You need to register first!");
            portalResponse.setStatusCode("202");
        }
        return portalResponse;
    }

    public List<UserEntity> fetch(){
        List<UserEntity> userEntity = repo.findAll();
        return userEntity;
    }
}
