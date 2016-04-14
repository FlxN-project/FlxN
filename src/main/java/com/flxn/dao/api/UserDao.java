package com.flxn.dao.api;

import com.flxn.dao.model.User;

/**
 * Created by X8 on 29.03.2016.
 */
public interface UserDao extends GenericDao<User> {
 boolean exist (int id);
 boolean exist(String email);
 User getByEmail(String email);
 String INSERT_USER="INSERT INTO \"USERS\" VALUES(DEFAULT,?,?)";
 String UPATE_USER_BY_ID="UPDATE \"USERS\" SET  \"EMAIL\"=?, \"PASSWORD\"=? WHERE \"USER_ID\"=?  ";
 String SELECT_BY_ID="SELECT \"USER_ID\",\"EMAIL\",\"PASSWORD\" FROM \"USERS\" WHERE \"USER_ID\"=? ";
 String SELECT_BY_EMAIL="SELECT \"USER_ID\",\"EMAIL\",\"PASSWORD\" FROM \"USERS\" WHERE \"EMAIL\"=? ";
}
