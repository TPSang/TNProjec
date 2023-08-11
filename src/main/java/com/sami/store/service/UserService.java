package com.sami.store.service;

import com.sami.store.api.model.LoginBody;
import com.sami.store.api.model.RegistrationBody;
import com.sami.store.entities.Users;
import com.sami.store.entities.repo.UserRepo;
import com.sami.store.exception.UserExitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    JWTService jwtService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    EncryptionService encryptionService;

    public Users regUser (RegistrationBody registrationBody)throws UserExitException {

           if (userRepo.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() || userRepo.findByUsernameIsIgnoreCase(registrationBody.getUsername()).isPresent()){
                throw new UserExitException();
        }
            Users  users = new Users();
            users.setEmail(registrationBody.getEmail());
            users.setUsername(registrationBody.getUsername());
            users.setName(registrationBody.getName());
            users.setPassword(encryptionService.encrypPassword(registrationBody.getPassword()));

            return userRepo.save(users);
    }




    public  String loginUser(LoginBody loginBodybody){
        Optional<Users> optionalUsers =userRepo.findByUsernameIsIgnoreCase(loginBodybody.getUsername());
        if(optionalUsers.isPresent()){
            Users users = optionalUsers.get();
           if(encryptionService.verifyPassword(loginBodybody.getPassword(),users.getPassword())){
               return jwtService.generateJWT(users);
           }
        }
        return null;
    }


}
