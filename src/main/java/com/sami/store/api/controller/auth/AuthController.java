package com.sami.store.api.controller.auth;

import com.sami.store.api.model.LoginBody;
import com.sami.store.api.model.LoginResponse;
import com.sami.store.api.model.RegistrationBody;
import com.sami.store.entities.Users;
import com.sami.store.exception.UserExitException;
import com.sami.store.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService service;

    @PostMapping("/reg")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody){
        try {
            service.regUser(registrationBody);
            return  ResponseEntity.ok().build();
        } catch (UserExitException e) {

        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody){
        String jwt = service.loginUser(loginBody);
        if (jwt == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/me")
    public Users getLoginUserProfile(@AuthenticationPrincipal Users user){
        return user;
    }
}
