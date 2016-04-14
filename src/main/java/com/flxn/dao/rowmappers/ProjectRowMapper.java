package com.flxn.dao.rowmappers;

import com.flxn.dao.model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by X8 on 14.04.2016.
 */
public class ProjectRowMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        Project project=new Project(resultSet.getString("TITLE"),resultSet.getString("DESCRIPTION"));
        project.setId(resultSet.getInt("PROJECT_ID"));
        return project;
    }
}
