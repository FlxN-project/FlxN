package com.flxn.dao.model;

/**
 * Created by X8 on 28.03.2016.
 */
public class Clazz {
    private int id;
    private String name;
    private String description;
    private Project project;

    public Clazz(){}

    public Clazz(int id, String name, String description, Project project){
        this.id=id;
        this.name=name;
        this.description = description;
        this.project=project;
    }
    public Clazz(String name, String description, Project project){
        this.id=-1;
        this.name=name;
        this.description = description;
        this.project=project;
    }

    public int getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    public Builder getBuilder(){ return  new Builder();}

    public static class Builder{
        private int id=-1;
        private String name="null";
        private String description="null";
        private Project project=null;

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
        public Builder project(Project project){
            this.project=project;
            return this;
        }

        public Clazz build(){return new Clazz(id,name,description,project);}
    }
}
