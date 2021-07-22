CREATE DATABASE users;

use users;

create table user
(
    ID             int unsigned auto_increment
        primary key,
    NAME           varchar(150) not null,
    STATUS         char         null,
    AGE            varchar(4)   null,
    JOB            varchar(128) null,
    GENDER         varchar(54)  null,
    PLACE_OF_BIRTH varchar(128) null,
    CREATED_USER   varchar(54)  null,
    CREATED_DATE   date         null,
    MODIFIED_USER  varchar(54)  null,
    MODIFIED_DATE  date         null
);