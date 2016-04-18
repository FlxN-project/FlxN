package com.flxn.dao.impl;

import com.flxn.dao.api.ClazzDao;
import com.flxn.dao.api.OwnerSecurityInterface;
import com.flxn.dao.model.Clazz;
import com.flxn.dao.model.Project;
import com.flxn.dao.rowmappers.ClazzRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by X8 on 15.04.2016.
 */
public class ClazzDaoImpl implements ClazzDao,OwnerSecurityInterface{
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Clazz> getClazzByProject(Project project, int userid) {
        if (existParentOwner(project.getId(),userid)){
        List<Clazz> clazzs=jdbcTemplate.query(SELECT_CLAZZ_LIST_BY_PROJECT_ID,new Object[]{project.getId()},new ClazzRowMapper());
        return clazzs;}
        else{return null;}
    }

    @Override
    public boolean exist(int id) {
        boolean result=jdbcTemplate.queryForObject(COUNT_ID_BY_ID,new Object[]{id},Integer.class)!=0;
        return result;

    }

    @Override
    public boolean exist(Clazz clazz) {
     boolean result=jdbcTemplate.queryForObject(COUNT_ID_BY_NAME_AND_PROJECT_ID,new Object[]{clazz.getName(),clazz.getParent().getId()},Integer.class)!=0;
     return result;
    }

    @Override
    public void create(Clazz object, int projectid, int userid) {
        if(!exist(object) && existParentOwner(projectid,userid)) {
            jdbcTemplate.update(INSERT_CLAZZ,new Object[]{object.getName(),object.getParent().getId(),object.getDescription()});
        }else{
            throw new UnsupportedOperationException();}
    }

    @Override
    public void delete(Clazz object,int userid) {
        if(exist(object) && existOwner(object.getId(),userid)) {
            jdbcTemplate.update(DELETE_CLAZZ_BY_ID,new Object[]{object.getId()});
        }else{
            throw new UnsupportedOperationException();}
    }

    @Override
    public void update(Clazz object, int userid) {
        if(!exist(object) && existOwner(object.getId(),userid)) {
            jdbcTemplate.update(UPATE_CLAZZ_BY_ID,new Object[]{object.getName(),object.getDescription(),object.getId()});}
            else
                if(exist(object.getId()) && existOwner(object.getId(),userid)){
                    jdbcTemplate.update(UPATE_CLAZZ_BY_ID,new Object[]{object.getName(),object.getDescription(),object.getId()});}
                    else{
                        throw new UnsupportedOperationException();}
    }

    @Override
    public Clazz getById(int id, int userid) {
        if(exist(id) && existOwner(id,userid)){
            Clazz clazz=jdbcTemplate.queryForObject(SELECT_CLAZZ_BY_ID,new Object[]{id},new ClazzRowMapper());
            return clazz;
        } else return null;
    }

    @Override
    public boolean existOwner(int idobject, int userid) {
        boolean result=jdbcTemplate.queryForObject(CLAZZ_OWNER_BY_ID,new Object[]{idobject},Integer.class)==userid;
        return result;
    }

    @Override
    public boolean existParentOwner(int projectid, int userid) {
        boolean result=jdbcTemplate.queryForObject(PROJECT_OWNER_BY_ID,new Object[]{projectid},Integer.class)==userid;
        return result;
    }
}
