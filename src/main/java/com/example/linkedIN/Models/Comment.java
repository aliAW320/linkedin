package com.example.linkedIN.Models;

import jakarta.persistence.*;

@Entity
public class Comment {
    public Comment() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String context;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;

    public Comment(User user, Post post, String context, Long id) {
        this.user = user;
        this.post = post;
        this.context = context;
        Id = id;
    }

    public Comment(String context, Post post, User user) {
        this.context = context;
        this.post = post;
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
