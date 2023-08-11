package com.poly.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersModel {
    private String username;
    private String password;
    private String email;
    private String fullname;
}
