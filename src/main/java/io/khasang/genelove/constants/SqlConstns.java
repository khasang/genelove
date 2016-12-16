package io.khasang.genelove.constants;

public class SqlConstns {

    public SqlConstns() {
    }
    public static final String DROP_TABLE_USER="DROP TABLE IF EXISTS users";
    public static final String DROP_TABLE_FILMS="DROP TABLE IF EXISTS films";
    public static final String CREATE_TABLE_USERS = "create table users (id int NOT NULL, name varchar(40) NOT NULL,id_film int)";
    public static final String CREATE_TABLE_FILMS = "create table films (id int NOT NULL, title varchar(40) NOT NULL)";

}
