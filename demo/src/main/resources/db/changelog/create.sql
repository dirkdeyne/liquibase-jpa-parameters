--liquibase formatted SQL
--changeset dirk:1
CREATE TABLE parameter_value(p_name varchar(20) primary key, p_value varchar(20));