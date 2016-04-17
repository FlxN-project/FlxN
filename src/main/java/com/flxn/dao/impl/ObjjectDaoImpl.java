package com.flxn.dao.impl;

import com.flxn.dao.api.ObjjectDao;
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
public class ObjjectDaoImpl implements ObjjectDao {
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
    public List<Objject> getObjjectListByClazz(Clazz clazz) {
        List<Objject> objjects=jdbcTemplate.query(SELECT_OBJJECT_LIST_BY_CLAZZ_ID,new Object[]{clazz.getId()},new ObjjectRowMapper());
        return objjects;
    }

    @Override
    public void create(Objject object) {
        if(!exist(object)){
           jdbcTemplate.update(INSERT_OBJJECT,new Object[]{object.getLink(),object.getParent().getId()});
        }
        else {
            throw  new UnsupportedOperationException();
        }
    }

    @Override
    public void delete(Objject object) {
        if(exist(object)){
            jdbcTemplate.update(DELETE_OBJJECT_BY_ID,new Object[]{object.getId()});
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void update(Objject object) {
        if(!exist(object)){
            jdbcTemplate.update(UPDATE_OBJJECT_BY_ID,new Object[]{object.getLink(),object.getId()});
        } else
            if(exist(object.getId())){
                jdbcTemplate.update(UPDATE_OBJJECT_BY_ID,new Object[]{object.getLink(),object.getId()});
            }else
                    {
                    throw new UnsupportedOperationException();}

    }

    @Override
    public Objject getById(int id) {
        if(exist(id)){
            Objject objject=jdbcTemplate.queryForObject(SELECT_OBJJECT_BY_ID,new Object[]{id},new ObjjectRowMapper());
            return objject;
        } else return null;
    }
}
