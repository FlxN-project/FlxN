package com.flxn.dao.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by X8 on 28.03.2016.
 */
public class Clazz implements  ModelInterface {

    @NotNull
    @Size(min=0,max =40)
    private String name;
    @Size (min=0,max =400)
    private String description;
    private Project project;
    private int id;


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
