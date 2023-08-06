package com.poly.models;

import jakarta.persistence.Entity;
import lombok.Data;
@Data
@Entity
public class users {
    String username ;
    String email ;
    String password ;
    String fullname ;
}
