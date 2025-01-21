package com.example.linkedIN.Controllers;

import com.example.linkedIN.DAO.PostDAO;
import com.example.linkedIN.DAO.UserDAO;
import com.example.linkedIN.Models.Comment;
import com.example.linkedIN.Models.Post;
import com.example.linkedIN.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//TODO puting comment is added but not tested
@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    public CommentController(PostDAO postDAO, UserDAO userDAO) {
        this.postDAO = postDAO;
        this.userDAO = userDAO;
    }
    @PostMapping
    public ResponseEntity addComment(@RequestParam Long postId, @RequestParam String userEmail, @RequestParam String context) {
        Optional<Post> post = postDAO.findById(postId);
        if (post.isPresent()) {
            User user =  userDAO.findByEmail(userEmail).get();
            if (user == null) {
                return ResponseEntity.status(404).body("not valid user");
            }
            Comment comment = new Comment(context , post.get(), user);
            post.get().getComments().add(comment);
            postDAO.save(post.get());
            return ResponseEntity.status(200).body(" comment added succssefully ");
        }
        return ResponseEntity.status(400).body("not valid post");
    }
}
