package com.example.linkedIN.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    public Comment() {
    }
    @Id
    private Long Id;
    @Column
    private String context;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;
}
