package com.sami.store.entities.repo;

import com.sami.store.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users,Long> {
    Optional<Users> findByEmailIgnoreCase(String email);
    Optional<Users> findByUsernameIsIgnoreCase(String username);

}
