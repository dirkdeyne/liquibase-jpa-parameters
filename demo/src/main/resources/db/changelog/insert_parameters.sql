--liquibase formatted sql
--changeset dirk:2
insert into parameter_value values ('first','${first}');
insert into parameter_value values ('second','${second}');