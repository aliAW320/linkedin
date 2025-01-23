package com.example.linkedIN.Controllers;

import com.example.linkedIN.DAO.PostDAO;
import com.example.linkedIN.DAO.UserDAO;
import com.example.linkedIN.Models.Post;
import com.example.linkedIN.Models.User;
import com.example.linkedIN.Utils.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//TODO test the add post
@RestController
@CrossOrigin
public class PostController {
    @Autowired
    private final PostDAO postDAO;
    @Autowired
    private final UserDAO userDAO;
    @Autowired
    public PostController(PostDAO postDAO , UserDAO userDAO) {
        this.postDAO = postDAO;
        this.userDAO = userDAO;
    }
    @PostMapping("post/create")
    public ResponseEntity addPost(@RequestParam String UserEmail ,@RequestParam String DataMedia,
                                  @RequestParam String MediaName , @RequestParam String caption){
        int code = 0;
        User owner = userDAO.findByEmail(UserEmail).get();
        if(owner == null){
            code = 404;
            return ResponseEntity.status(404).body("User not found");
        }
        Post post = new Post(owner , Media.downloadMedia(MediaName , DataMedia) , caption);
        postDAO.save(post);
        owner.getPosts().add(post);
        userDAO.save(owner);
        return ResponseEntity.status(200).body("Post added successfully");
    }
}
