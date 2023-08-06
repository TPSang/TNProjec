package com.poly.entity;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Table"uses"
public class user {
    @Id
    @Column 
    String username ;
    String email ;
    String password ;
    String fullname ;
}
