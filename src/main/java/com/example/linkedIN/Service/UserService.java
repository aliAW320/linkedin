package com.example.linkedIN.Service;

import com.example.linkedIN.DAO.UserDAO;
import com.example.linkedIN.Models.ChangePasswordRequest;
import com.example.linkedIN.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserDAO repository;

    public UserService(PasswordEncoder passwordEncoder, UserDAO repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        repository.save(user);
    }
}
