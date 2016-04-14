package com.flxn.dao.rowmappers;

import com.flxn.dao.model.Clazz;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by X8 on 14.04.2016.
 */
public class ClazzRowMapper implements RowMapper<Clazz> {
    @Override
    public Clazz mapRow(ResultSet resultSet, int i) throws SQLException {
       Clazz clazz=new Clazz(resultSet.getString("NAME"),resultSet.getString("DESCRIPTION"));
       clazz.setId(resultSet.getInt("CLASS_ID"));
       return clazz;
    }
}
