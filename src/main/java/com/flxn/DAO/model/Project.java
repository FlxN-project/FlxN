package com.flxn.dao.model;


import com.flxn.dao.modelapi.ParentInterface;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by X8 on 28.03.2016.
 */

public class Project implements ParentInterface<User> {
    @NotNull
    @Size (min=0,max=30)
    private String name;
    @Size (min=0,max=400)
    private String description;
    private User user;
    private int id;


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

    public User getParent() {
        return user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(User user) {
        this.user = user;
    }
}
