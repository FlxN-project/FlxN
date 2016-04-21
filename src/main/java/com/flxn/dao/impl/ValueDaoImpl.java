package com.flxn.dao.impl;

import com.flxn.dao.api.OwnerSecurityInterface;
import com.flxn.dao.api.ValueDao;
import com.flxn.dao.model.Atribute;
import com.flxn.dao.model.Objject;
import com.flxn.dao.model.Value;
import com.flxn.dao.rowmappers.ValueRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by X8 on 15.04.2016.
 */
public class ValueDaoImpl implements ValueDao,OwnerSecurityInterface {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Override
    public boolean exist(int id) {
        boolean result=jdbcTemplate.queryForObject(COUNT_ID_BY_ID,new Object[]{id},Integer.class)!=0;
        return result;
    }

    @Override
    public boolean exist(Value value) {
        boolean result=jdbcTemplate.queryForObject(COUNT_ID_BY_ATRIBUTE_ID_AND_OBJJECT_ID,new Object[]{value.getAtribute().getId(),value.getParent().getId()},Integer.class)!=0;
        return result;
    }

    @Override
    public List<Value> getValueListByObjject(Objject objject, int userid) {
        if (existParentOwner(objject.getId(),userid)){
        List<Value> values=jdbcTemplate.query(SELECT_VALUE_LIST_BY_OBJJECT_ID,new Object[]{objject.getId()},new ValueRowMapper());
        return values;}
        else {return null;}
    }

    @Override
    public List<Value> getValueListByAtribute(Atribute atribute) {
        List<Value> values=jdbcTemplate.query(SELECT_VALUE_LIST_BY_ATRIBUTE_ID,new Object[]{atribute.getId()},new ValueRowMapper());
        return values;
    }

    @Override
    public void create(Value object, int objjectid, int userid) {
        if(!exist(object) && existParentOwner(objjectid,userid)){
            jdbcTemplate.update(INSERT_VALUE,new Object[]{object.getAtribute().getId(),object.getParent().getId(),object.getWeight()});
        } else{
            throw new UnsupportedOperationException();}
    }

    @Override
    public void delete(Value object, int userid) {
        if(exist(object.getId()) && existOwner(object.getId(),userid)){
            jdbcTemplate.update(DELETE_VALUE_BY_ID,new Object[]{object.getId()});
        }else{
            throw new UnsupportedOperationException();}
    }

    @Override
    public void update(Value object, int userid) {
        if(!exist(object) && existOwner(object.getId(),userid)){
            jdbcTemplate.update(UPDATE_VALUE_BY_ID,new Object[]{object.getWeight(),object.getAtribute().getId(),object.getParent().getId()});
        }else
            if(exist(object.getId()) && existOwner(object.getId(),userid)) {
                jdbcTemplate.update(UPDATE_VALUE_BY_ID,new Object[]{object.getWeight(),object.getAtribute().getId(),object.getParent().getId()}); }
                     else{ throw new UnsupportedOperationException();}

    }

    @Override
    public Value getById(int id, int userid) {
        if(exist(id) && existOwner(id,userid)){
            Value value=jdbcTemplate.queryForObject(SELECT_VALUE_BY_ID,new Object[]{id},new ValueRowMapper());
            return value;
        } else return null;
    }

    @Override
    public boolean existOwner(int idobject, int userid) {
        boolean result=jdbcTemplate.queryForObject(VALUE_OWNER_BY_ID,new Object[]{idobject},Integer.class)==userid;
        return result;}

    @Override
    public boolean existParentOwner(int objjectid, int userid) {
        boolean result=jdbcTemplate.queryForObject(OBJJECT_OWNER_BY_ID,new Object[]{objjectid},Integer.class)==userid;
        return result;
    }
}
