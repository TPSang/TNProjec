package com.poly.app.Entity;

import jakarta.persistence.*;

@Table(name = "address")
@Entity
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "locate", nullable = false)
    private String locate;

    @Column(name = "destric", nullable = false)
    private String destric;

    @Column(name = "city", nullable = false)
    private String city;

    @ManyToOne(optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    @ManyToOne(optional = false)
    @JoinColumn(name = "products_id", nullable = false)
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDestric() {
        return destric;
    }

    public void setDestric(String destric) {
        this.destric = destric;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}