package com.example.linkedIN.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post {
    public Post() {
    }
    @Id
    private Long Id;
    @ManyToOne
    private User owner;
    @Column
    private String media;
    @OneToMany
    private List<Comment> comments;
}
