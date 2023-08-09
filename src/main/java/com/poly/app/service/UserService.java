package com.poly.app.service;

import com.poly.app.Entity.Users;
import com.poly.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<Users> listUsers() {
        return userRepo.findAll();
    }

    public Users getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public Users createUser(Users user) {
        return userRepo.save(user);
    }

    public Users updateUser(Long id, Users updatedUser) {
        Users existingUser = userRepo.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            // Update other fields as needed
            return userRepo.save(existingUser);
        }
        return null; // User with the given id was not found
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
