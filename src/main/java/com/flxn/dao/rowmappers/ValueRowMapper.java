package com.flxn.dao.rowmappers;

import com.flxn.dao.model.Value;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by X8 on 14.04.2016.
 */
public class ValueRowMapper implements RowMapper<Value>{

    @Override
    public Value mapRow(ResultSet resultSet, int i) throws SQLException {
        Value value=new Value(resultSet.getString("VALUE"));
        value.setId(resultSet.getInt("VALUE_ID"));
        return value;
    }
}
