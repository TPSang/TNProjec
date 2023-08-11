package com.sami.store.api.model;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegistrationBody {

    private String username;
    private String password;

    @Email
    private String email;

    private String name;
}
