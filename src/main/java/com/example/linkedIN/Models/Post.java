package com.example.linkedIN.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post {
    public Post() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    private User owner;
    @Column
    private String media;
    @Column
    private String caption;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String title) {
        this.caption = title;
    }

    public Post(User owner, String media, String caption) {
        this.owner = owner;
        this.media = media;
        this.caption = caption;
    }

    public Post(Long id, User owner, String media, String caption) {
        Id = id;
        this.owner = owner;
        this.media = media;
        this.caption = caption;
    }

    @OneToMany
    private List<Comment> comments;

    public Post(Long id, User owner, String media) {
        Id = id;
        this.owner = owner;
        this.media = media;
    }

    public Post(User owner, String media) {
        this.owner = owner;
        this.media = media;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
