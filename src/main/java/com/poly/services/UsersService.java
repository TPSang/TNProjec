package com.poly.services;
import com.poly.models.Users;
import java.util.List;

public interface UsersService {
    List<Users> getAllUsers();

    Users getUserByUsername(String username);

    Users saveUser(Users user);

    void deleteUser(String username);
}