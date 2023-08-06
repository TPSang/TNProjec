package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.Repository.UsersRepository;
import com.poly.models.Users;


@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/{username}")
    public Users getUserByUsername(@PathVariable String username) {
        return usersRepository.findById(username).orElse(null);
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersRepository.save(user);
    }

    @PutMapping("/{username}")
    public Users updateUser(@PathVariable String username, @RequestBody Users updatedUser) {
        Users user = usersRepository.findById(username).orElse(null);
        if (user != null) {
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setFullname(updatedUser.getFullname());
            return usersRepository.save(user);
        }
        return null;
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        usersRepository.deleteById(username);
    }
}