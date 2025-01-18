package com.example.linkedIN.DAO;

import com.example.linkedIN.Models.Post;
import com.example.linkedIN.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostDAO extends JpaRepository<Post, Long> {
    public List<Post> findByOwner(User owner);
    public Optional<Post> findById(Long id);
}
