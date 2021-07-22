package com.beransantur.usermanagementapi.utils.constants;

public class UserRepositoryConstants {

    private UserRepositoryConstants() {
    }

    public static final String GET_USER_BASE = "SELECT * FROM USER ";

    public static final String GET_USER_DETAIL = GET_USER_BASE + " WHERE ID=:id ";

    public static final String GET_ALL_USERS_BY_STATUS = GET_USER_BASE + " WHERE STATUS=:status ";

    public static final String GET_ALL_USERS = GET_USER_BASE+ " WHERE STATUS =:status OR STATUS=:status1 ";

    public static final String SAVE_USER = "INSERT INTO USER (NAME, STATUS, AGE, JOB, GENDER, PLACE_OF_BIRTH, CREATED_USER, CREATED_DATE ) VALUES (:name, :status, :age," +
            ":job, :gender, :placeOfBirth, :createdUser, :createdDate )";

    public static final String GET_MAX_ID = "SELECT MAX(ID) FROM USER ";

    public static final String DELETE_USER = "UPDATE USER SET STATUS=:status, MODIFIED_USER=:modifiedUser, MODIFIED_DATE=:modifiedDate WHERE ID=:id ";

    public static final String UPDATE_USER = "UPDATE USER SET NAME=:name, AGE=:age, JOB=:job, GENDER=:gender, PLACE_OF_BIRTH=:placeOfBirth, " +
            "MODIFIED_USER=:modifiedUser, MODIFIED_DATE=:modifiedDate WHERE ID=:id ";

    public static final String GET_USER_STATUS_BY_ID = "SELECT STATUS FROM USER WHERE ID =:id ";
}
