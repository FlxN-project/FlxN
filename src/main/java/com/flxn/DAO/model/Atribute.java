package com.flxn.dao.model;

/**
 * Created by X8 on 28.03.2016.
 */
public class Atribute {
    private int id;
    private String name;
    private Clazz clazz;

    public Atribute(){}

    public Atribute(int id,String name,Clazz clazz){
        this.id=id;
        this.name=name;
        this.clazz=clazz;
    }

    public Atribute(String name,Clazz clazz){
        this.id=-1;
        this.name=name;
        this.clazz=clazz;
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

    public Builder getBuilder(){ return  new Builder();}

    public static class Builder{
       private int id=-1;
       private String name="null";
       private Clazz clazz=null;

      public Builder id(int id){
          this.id=id;
          return this;
      }
      public Builder name(String name){
          this.name=name;
          return this;
      }
      public Builder clazz(Clazz clazz){
          this.clazz=clazz;
          return this;
      }
      public Atribute build(){return new Atribute(id,name,clazz);}
    }
}
