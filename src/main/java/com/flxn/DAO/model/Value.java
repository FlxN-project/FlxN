package com.flxn.DAO.model;

/**
 * Created by X8 on 28.03.2016.
 */
public class Value {
    private int id;
    private String weight;
    private Atribute atribute;
    private Objject objject;

    public Value(){}

    public Value(int id, String weight, Atribute atribute, Objject objject){
        this.id=id;
        this.weight = weight;
        this.atribute=atribute;
        this.objject=objject;
    }
    public Value(String weight, Atribute atribute, Objject objject){
        this.id=-1;
        this.weight = weight;
        this.atribute=atribute;
        this.objject=objject;
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

    public Builder getBuilder(){ return  new Builder();}
     public static class Builder{
         private int id=-1;
         private String weight="-1";
         private Atribute atribute=null;
         private Objject objject=null;

         public Builder id(int id){
             this.id=id;
             return this;
         }

         public Builder weight(String weight){
             this.weight=weight;
             return this;
         }

         public Builder atribute(Atribute atribute){
             this.atribute=atribute;
             return this;
         }

         public Builder objject(Objject objject){
             this.objject=objject;
             return this;
         }

         public Value build(){
             return  new Value(id,weight,atribute,objject);
         }
    }
}
