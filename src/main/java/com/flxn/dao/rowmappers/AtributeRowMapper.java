package com.flxn.dao.rowmappers;

import com.flxn.dao.model.Atribute;
import org.springframework.asm.Attribute;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by X8 on 14.04.2016.
 */
public class AtributeRowMapper implements RowMapper<Atribute> {
    @Override
    public Atribute mapRow(ResultSet resultSet, int i) throws SQLException {
        Atribute atribute=new Atribute(resultSet.getString("NAME"));
        atribute.setId(resultSet.getInt("ATTRIBUTE_ID"));
        return  atribute;
    }
}
