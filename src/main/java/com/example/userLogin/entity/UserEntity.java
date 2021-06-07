package com.example.userLogin.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "UserInfo")
public class UserEntity {

    @Id
    private String id;

    @Column
    private int age;

    @Column
    private String pass;

}
