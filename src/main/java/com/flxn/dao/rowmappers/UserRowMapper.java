package com.flxn.dao.rowmappers;

import com.flxn.dao.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by X8 on 14.04.2016.
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User(resultSet.getString("EMAIL"),resultSet.getString("PASSWORD"));
        user.setId(resultSet.getInt("USER_ID"));
        return user;
    }
}
