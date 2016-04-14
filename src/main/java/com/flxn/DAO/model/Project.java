package com.flxn.dao.model;


/**
 * Created by X8 on 28.03.2016.
 */

public class Project {
    private int id;
    private String name;
    private String description;
    private User user;

    public Project(){}

    public Project(String name,String description){
        this.name=name;
        this.description=description;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
