package com.flxn.dao.model;

/**
 * Created by X8 on 28.03.2016.
 */
public class User {
    private int id;
    private String email;
    private String password;

    public User() {}
    public User(String email, String password){
        this.email=email;
        this.password=password;
    }
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
