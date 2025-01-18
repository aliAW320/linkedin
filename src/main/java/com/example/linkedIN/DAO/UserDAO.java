package com.example.linkedIN.DAO;

import com.example.linkedIN.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);
    public User findByName(String name);
}
