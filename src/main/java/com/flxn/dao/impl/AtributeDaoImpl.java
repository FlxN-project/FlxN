package com.flxn.dao.impl;

import com.flxn.dao.api.AtributeDao;
import com.flxn.dao.model.Atribute;
import com.flxn.dao.model.Clazz;
import com.flxn.dao.rowmappers.AtributeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by X8 on 15.04.2016.
 */
public class AtributeDaoImpl implements AtributeDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean exist(int id) {
        boolean result=jdbcTemplate.queryForObject(COUNT_ID_BY_ID,new Object[]{id},Integer.class)!=0;
        return result;
    }

    @Override
    public boolean exist(Atribute atribute) {
        boolean result=jdbcTemplate.queryForObject(COUNT_ID_BY_NAME_AND_CLAZZ_ID,new Object[]{atribute.getName(),atribute.getClazz().getId()},Integer.class)!=0;
        return result;
    }

    @Override
    public List<Atribute> getAtributeListByClazz(Clazz clazz) {
        List<Atribute> atributes=jdbcTemplate.query(SELECT_ATRIBUTE_LIST_BY_CLAZZ_ID,new Object[]{clazz.getId()},new AtributeRowMapper());
        return atributes;
    }

    @Override
    public void create(Atribute object) {
        if(!exist(object)){
            jdbcTemplate.update(INSERT_ATRIBUTE,new Object[]{object.getClazz().getId(),object.getName()});
        }else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void delete(Atribute object) {
        if(exist(object)){
            jdbcTemplate.update(DELETE_ATRIBUTE_BY_ID,new Object[]{object.getId()});
        }else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void update(Atribute object) {
        if(exist(object)){
            jdbcTemplate.update(UPDATE_ATRIBUTE_BY_ID,new Object[]{object.getName(),object.getId()});
        }else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Atribute getById(int id) {
       if(exist(id)){
           Atribute atribute=jdbcTemplate.queryForObject(SELECT_ATRIBUTE_BY_ID,new Object[]{id},new AtributeRowMapper());
           return atribute;
       }else{
          return null;
       }
    }
}
