package com.flxn.dao.model;

/**
 * Created by X8 on 28.03.2016.
 */
public class Objject {
    private int id;
    private Clazz clazz;
    private String link;

    public Objject(){}

    public Objject(String link){
        this.link=link;
    }

    public int getId() {
        return id;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public String getLink() {
        return link;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
