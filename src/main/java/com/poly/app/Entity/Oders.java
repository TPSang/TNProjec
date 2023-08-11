package com.poly.app.Entity;

import jakarta.persistence.*;

@Table(name = "oders")
@Entity
public class Oders {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "users_id", nullable = true)
    private Users users;

    @ManyToOne(optional = false)
    @JoinColumn(name = "products_id", nullable = true)
    private Products products;

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}