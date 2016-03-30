package com.flxn.dao.model;

/**
 * Created by X8 on 28.03.2016.
 */
public class Objject {
    private int id;
    private Clazz clazz;
    private String link;

    public Objject(){}

    public Objject(int id,Clazz clazz,String link){
        this.id=id;
        this.clazz=clazz;
        this.link=link;
    }

    public Objject(Clazz clazz,String link){
        this.id=-1;
        this.clazz=clazz;
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
    public Builder getBuilder(){ return  new Builder();}

    public static class Builder{
        private int id=-1;
        private Clazz clazz=null;
        private String link=null;

        public Builder id(int id){
            this.id=id;
            return this;
        }
        public Builder clazz(Clazz clazz){
            this.clazz=clazz;
            return this;
        }
        public Builder link(String link){
            this.link=link;
            return this;
        }

        public Objject build(){return new Objject(id,clazz,link);}
    }
}
