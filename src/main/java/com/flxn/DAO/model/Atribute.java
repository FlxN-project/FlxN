package com.flxn.dao.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by X8 on 28.03.2016.
 */
public class Atribute implements ModelInterface {

    @NotNull
    @Size(min=0,max =40)
    private String name;
    private Clazz clazz;
    private int id;


    public Atribute(){}

    public Atribute(String name){
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
