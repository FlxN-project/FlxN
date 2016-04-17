package com.flxn.dao.impl;

import com.flxn.dao.api.ProjectDao;
import com.flxn.dao.model.Project;
import com.flxn.dao.model.User;
import com.flxn.dao.rowmappers.ProjectRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by X8 on 15.04.2016.
 */
public class ProjectDaoImpl implements ProjectDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Project> getProjectListByUser(User user) {
        List<Project> projects=jdbcTemplate.query(SELECT_PROJECT_LIST_BY_USER_ID,new Object[]{user.getId()},new ProjectRowMapper());
        return projects;
    }

    @Override
    public void create(Project object) {
        if(!exist(object)){
            jdbcTemplate.update(INSERT_PROJECT,new Object[]{object.getName(),object.getParent().getId(),object.getDescription()});
        }else{
            throw new UnsupportedOperationException();}
    }

    @Override
    public void delete(Project object) {
        if(exist(object)){
            jdbcTemplate.update(DELETE_PROJECT_BY_ID,new Object[]{object.getId()});
        }else{
            throw new UnsupportedOperationException();}
    }

    @Override
    public boolean exist(Project project) {
        boolean result=jdbcTemplate.queryForObject(SELECT_COUNT_ID_BY_TITLE_AND_USER,new Object[]{project.getName(),project.getParent().getId()},Integer.class)!=0;
        return result;
    }

    @Override
    public boolean exist(int id) {
        boolean result=jdbcTemplate.queryForObject(SELECT_COUNT_ID_BY_ID,new Object[]{id},Integer.class)!=0;
        return result;
    }

    @Override
    public void update(Project object) {
        if(exist(object)){
            jdbcTemplate.update(UPDATE_PROJECT_BY_ID,new Object[]{object.getName(),object.getDescription(),object.getId()});
        }else{
            throw new UnsupportedOperationException();}
    }

    @Override
    public Project getById(int id) {
        if(exist(id)){
        Project project=jdbcTemplate.queryForObject(SELECT_PROJECT_BY_ID,new Object[]{id},new ProjectRowMapper());
        return project;
        }
        else
        return null;
    }
}
