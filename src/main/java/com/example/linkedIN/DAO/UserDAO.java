package com.example.linkedIN.DAO;

import com.example.linkedIN.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
    public Optional<User> findByName(String name);

}
