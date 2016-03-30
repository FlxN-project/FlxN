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

    public Project(int id,String name,String description,User user){
        this.id=id;
        this.name=name;
        this.description=description;
        this.user=user;
    }
    public Project(String name,String description,User user){
        this.id=-1;
        this.name=name;
        this.description=description;
        this.user=user;
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

    public Builder getBuilder(){ return  new Builder();}

    public static class Builder{
        private int id=-1;
        private String name="null";
        private String description="null";
        private User user=null;

        public Builder id(int id){
            this.id=id;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        public Builder description(String description){
            this.description=description;
            return this;
        }
        public Builder user(User user){
            this.user=user;
            return this;
        }

        public Project build(){return new Project(id,name,description,user);}
    }
}
