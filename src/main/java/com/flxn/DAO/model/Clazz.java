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

    public Clazz(String name, String description){
        this.name=name;
        this.description = description;
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
}
