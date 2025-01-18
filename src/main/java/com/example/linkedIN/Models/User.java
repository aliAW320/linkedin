package com.example.linkedIN.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User {

    public User() {}
    @Id
    private Long id;
    @Column
    private String name;
    @Column(unique = true , nullable = false)
    private String email;
    @Column
    private String password;
    @Column(unique = true)
    private String phone;
    @Column
    private String address;
    @OneToMany
    private List<Post> posts;
    @OneToMany
    private List<User> users;
    @Column(length = 500)
    private String description;

    public User(String name, String email, String password, String phone, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
