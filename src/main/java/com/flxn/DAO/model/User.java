package com.flxn.dao.model;

import com.flxn.dao.modelapi.ModelInterface;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Created by X8 on 28.03.2016.
 */
public class User implements ModelInterface {
    private int id;
    @NotNull
    @Size (min=0,max=100)
    private String password;
    @NotNull
    @Size(min=0,max=30)
    private String email;

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
