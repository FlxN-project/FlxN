package com.flxn.dao.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by X8 on 28.03.2016.
 */
public class Value {
    private int id;
    private Atribute atribute;
    private Objject objject;
    @NotNull
    @Size(min=0,max=250)
    private String weight;



    public Value(){}

    public Value(String weight){
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getWeight() {
        return weight;
    }

    public Objject getObjject() {
        return objject;
    }

    public Atribute getAtribute() {
        return atribute;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAtribute(Atribute atribute) {
        this.atribute = atribute;
    }

    public void setObjject(Objject objject) {
        this.objject = objject;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
