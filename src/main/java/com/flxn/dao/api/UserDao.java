package com.flxn.dao.api;

import com.flxn.dao.model.User;

/**
 * Created by X8 on 29.03.2016.
 */
public interface UserDao extends GenericDao<User> {
 boolean exist(String email);
}
