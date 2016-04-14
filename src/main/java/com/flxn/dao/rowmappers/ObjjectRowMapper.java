package com.flxn.dao.rowmappers;

import com.flxn.dao.model.Objject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by X8 on 14.04.2016.
 */
public class ObjjectRowMapper implements RowMapper<Objject> {

    @Override
    public Objject mapRow(ResultSet resultSet, int i) throws SQLException {
        Objject objject=new Objject(resultSet.getString("LINK"));
        objject.setId(resultSet.getInt("OBJECT_ID"));
        return objject;

    }
}
