package com.flxn.dao.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by X8 on 31.03.2016.
 */
public class FlexObjject {
    private int id;
    private String name;
    private HashMap atributeValue=new HashMap<String,String>();

    public FlexObjject(){}
    public FlexObjject(Objject objject, List<Atribute> atributes,List<Value> values) {
       this.id=objject.getId();
       this.name = objject.getLink();
        if (atributes.size() == values.size()) {
            for (int i = 0; i < atributes.size(); i++) {
                atributeValue.put(atributes.get(i).getName(), values.get(i).getWeight());
            }
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public String getName() {
        return name;
    }

    public void setAtributeValue(HashMap<String, String> atributeValue) {
        this.atributeValue = atributeValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getAtributeValue() {
        return atributeValue;
    }
    public String getValueByAtribute(Atribute atribute){
    return  getAtributeValue().get(atribute.getName());
    }
}
