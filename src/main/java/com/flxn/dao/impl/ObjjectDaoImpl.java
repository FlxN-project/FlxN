package com.flxn.dao.impl;

import com.flxn.dao.api.ObjjectDao;
import com.flxn.dao.api.OwnerSecurityInterface;
import com.flxn.dao.model.Clazz;
import com.flxn.dao.model.Objject;
import com.flxn.dao.rowmappers.ObjjectRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by X8 on 15.04.2016.
 */
public class ObjjectDaoImpl implements ObjjectDao,OwnerSecurityInterface {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean exist(int id) {
        boolean result=jdbcTemplate.queryForObject(COUNT_ID_BY_ID,new Object[]{id},Integer.class)!=0;
        return result;
    }

    @Override
    public boolean exist(Objject objject) {
        boolean result=jdbcTemplate.queryForObject(COUNT_ID_BY_NAME_AND_CLAZZ_ID,new Object[]{objject.getLink(),objject.getParent().getId()},Integer.class)!=0;
        return result;
    }

    @Override
    public List<Objject> getObjjectListByClazz(Clazz clazz, int userid) {
        if(existParentOwner(clazz.getId(),userid)){
        List<Objject> objjects=jdbcTemplate.query(SELECT_OBJJECT_LIST_BY_CLAZZ_ID,new Object[]{clazz.getId()},new ObjjectRowMapper());
        return objjects;}
        else {return null;}
    }

    @Override
    public void create(Objject object, int clazzid, int userid) {
        if(!exist(object) && existParentOwner(clazzid,userid)){
           jdbcTemplate.update(INSERT_OBJJECT,new Object[]{object.getLink(),object.getParent().getId()});
        }
        else {
            throw  new UnsupportedOperationException();
        }
    }

    @Override
    public void delete(Objject object, int userid) {
        if(exist(object.getId()) && existOwner(object.getId(),userid)){
            jdbcTemplate.update(DELETE_OBJJECT_BY_ID,new Object[]{object.getId()});
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void update(Objject object,int userid) {
        if(!exist(object) && existOwner(object.getId(),userid)){
            jdbcTemplate.update(UPDATE_OBJJECT_BY_ID,new Object[]{object.getLink(),object.getId()});
        } else
            if(exist(object.getId()) && existOwner(object.getId(),userid)){
                jdbcTemplate.update(UPDATE_OBJJECT_BY_ID,new Object[]{object.getLink(),object.getId()});
            }else
                    {
                    throw new UnsupportedOperationException();}

    }

    @Override
    public Objject getById(int id, int userid) {
        if(exist(id) && existOwner(id,userid)){
            Objject objject=jdbcTemplate.queryForObject(SELECT_OBJJECT_BY_ID,new Object[]{id},new ObjjectRowMapper());
            return objject;
        } else return null;
    }

    @Override
    public boolean existOwner(int idobject, int userid) {
        boolean result=jdbcTemplate.queryForObject(OBJJECT_OWNER_BY_ID,new Object[]{idobject},Integer.class)==userid;
        return result;
    }

    @Override
    public boolean existParentOwner(int clazzid, int userid) {
        boolean result=jdbcTemplate.queryForObject(CLAZZ_OWNER_BY_ID,new Object[]{clazzid},Integer.class)==userid;
        return result;
    }
}
