package com.example.deathquiz;

import java.lang.ref.SoftReference;

public class User {
    public String fullName, username, email;

    public User(){

    }

    public User(String fullName, String username, String email){
        this.fullName = fullName;
        this.username = username;
        this.email = email;

    }
}
