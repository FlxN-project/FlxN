package com.flxn.dao.model;

import com.flxn.dao.modelapi.ParentInterface;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by X8 on 28.03.2016.
 */
public class Objject implements ParentInterface<Clazz> {

    @NotNull
    @Size(min=0,max =40)
    private String link;
    private int id;
    private Clazz clazz;


    public Objject(){}

    public Objject(String link){
        this.link=link;
    }

    public int getId() {
        return id;
    }

    public Clazz getParent() {
        return clazz;
    }

    public String getLink() {
        return link;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParent(Clazz clazz) {
        this.clazz = clazz;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
