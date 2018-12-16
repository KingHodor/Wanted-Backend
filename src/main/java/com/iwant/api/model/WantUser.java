package com.iwant.api.model;

import javax.persistence.*;

@Entity
@Table(name = "want_user")
public class WantUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String userId;
    String email;
    String name;

    public WantUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}