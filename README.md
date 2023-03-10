# liquibase-jpa-parameters

Proof of concept usage [parameters](https://github.com/dirkdeyne/liquibase-jpa-parameters/blob/853327f7f90646e0fd5dbcc65ba4e3a6265952d5/demo/src/main/resources/application.properties#L4) in liquibase when using `.sql` files like [insert_parameters.sql](https://github.com/dirkdeyne/liquibase-jpa-parameters/blob/2f254fd0e9468faef34cd6893bd033e406225ac5/demo/src/main/resources/db/changelog/insert_parameters.sql#L1)


Assuming your _inserts_ are done in a _xxx.sql_ file then it is **IMPORTANT** you tell liquibase your SQL is formatted, you can do that by adding
 `--liquibase formatted sql` at the top of your file

example: inserts.sql
```sql
--liquibase formatted SQL
--changeset Greg:1
insert into table1 (name, value) values ('nameOfValue', '${val1}');
```
