package com.flxn.dao.impl;

import com.flxn.dao.api.UserDao;
import com.flxn.dao.model.User;
import com.flxn.dao.rowmappers.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;


/**
 * Created by X8 on 13.04.2016.
 */
public class UserDaoImpl implements UserDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean exist(int id) {
        boolean result=jdbcTemplate.queryForObject(SELECT_COUNT_EMAIL,new Object[]{id},Integer.class)!=0;
        return result;
    }

    @Override
    public boolean exist(String email) {
            boolean result=jdbcTemplate.queryForObject(SELECT_COUNT_ID,new Object[]{email},Integer.class)!=0;
            return result;
    }

    @Override
    public User getByEmail(String email) {
        if (exist(email)){
            User user=jdbcTemplate.queryForObject(SELECT_BY_EMAIL,new Object[]{email},new UserRowMapper());
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public void create(User object) {
        if(!exist(object.getEmail()))
        {
            jdbcTemplate.update(INSERT_USER,new Object[]{object.getEmail(),object.getPassword()});
         } else
           throw new UnsupportedOperationException();
    }

    @Override
    public void delete(User object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(User object) {
        if(!exist(object.getId())){
            jdbcTemplate.update(UPATE_USER_BY_ID,new Object[]{object.getEmail(),object.getPassword(),object.getId()});
        }
        else if(exist(object.getId())) {
                 jdbcTemplate.update(UPATE_USER_BY_ID,new Object[]{object.getEmail(),object.getPassword(),object.getId()});}
                else{
                    throw new UnsupportedOperationException();}
    }

    @Override
    public User getById(int id) {
        if (exist(id)){
            User user=jdbcTemplate.queryForObject(SELECT_BY_ID,new Object[]{id},new UserRowMapper());
            return user;
        }
        else {
            return null;
        }
    }
}
