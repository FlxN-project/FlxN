package com.flxn.dao.api;

/**
 * Created by X8 on 17.04.2016.
 */
public interface OwnerSecurityInterface {
    boolean existOwner(int idobject,int iduser);
    String VALUE_OWNER_BY_ID="SELECT \"USERS\".\"USER_ID\"\n" +
            "FROM \"USERS\"\n" +
            "INNER JOIN \"PROJECTS\" ON \"PROJECTS\".\"USER_ID\"=\"USERS\".\"USER_ID\" \n" +
            "INNER JOIN \"CLASSES\" ON \"CLASSES\".\"PROJECT_ID\"=\"PROJECTS\".\"PROJECT_ID\" \n" +
            "INNER JOIN \"OBJECTS\" ON \"OBJECTS\".\"CLASS_ID\"=\"CLASSES\".\"CLASS_ID\" \n" +
            "INNER JOIN \"VALUES\" ON \"VALUES\".\"OBJECT_ID\"=\"OBJECTS\".\"OBJECT_ID\" \n" +
            "WHERE \"VALUES\".\"VALUE_ID\"=? ";
    String OBJJECT_OWNER_BY_ID="SELECT \"USERS\".\"USER_ID\"\n" +
            "FROM \"USERS\"\n" +
            "INNER JOIN \"PROJECTS\" ON \"PROJECTS\".\"USER_ID\"=\"USERS\".\"USER_ID\" \n" +
            "INNER JOIN \"CLASSES\" ON \"CLASSES\".\"PROJECT_ID\"=\"PROJECTS\".\"PROJECT_ID\" \n" +
            "INNER JOIN \"OBJECTS\" ON \"OBJECTS\".\"CLASS_ID\"=\"CLASSES\".\"CLASS_ID\" \n" +
            "WHERE \"OBJECTS\".\"OBJECT_ID\"=? ";
    String ATTRIBUTE_OWNER_BY_ID="SELECT \"USERS\".\"USER_ID\"\n" +
            "FROM \"USERS\"\n" +
            "INNER JOIN \"PROJECTS\" ON \"PROJECTS\".\"USER_ID\"=\"USERS\".\"USER_ID\" \n" +
            "INNER JOIN \"CLASSES\" ON \"CLASSES\".\"PROJECT_ID\"=\"PROJECTS\".\"PROJECT_ID\" \n" +
            "INNER JOIN \"ATTRIBUTES\" ON \"ATTRIBUTES\".\"CLASS_ID\"=\"CLASSES\".\"CLASS_ID\" \n" +
            "WHERE \"ATTRIBUTES\".\"ATTRIBUTE_ID\"=? ";
    String CLAZZ_OWNER_BY_ID="SELECT \"USERS\".\"USER_ID\"\n" +
            "FROM \"USERS\"\n" +
            "INNER JOIN \"PROJECTS\" ON \"PROJECTS\".\"USER_ID\"=\"USERS\".\"USER_ID\" \n" +
            "INNER JOIN \"CLASSES\" ON \"CLASSES\".\"PROJECT_ID\"=\"PROJECTS\".\"PROJECT_ID\" \n" +
            "WHERE \"CLASSES\".\"CLASS_ID\"=? ";
    String PROJECT_OWNER_BY_ID="SELECT \"USERS\".\"USER_ID\" FROM \"USERS\" INNER JOIN \"PROJECTS\" ON \"PROJECTS\".\"USER_ID\"=\"USERS\".\"USER_ID\" \n" +
            "WHERE \"PROJECTS\".\"PROJECT_ID\"=? ";
    String USES_OWNER_BY_ID="SELECT \"USERS\".\"USER_ID\"FROM \"USERS\" WHERE \"USERS\".\"USER_ID\"=? ";


}
