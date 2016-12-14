package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Denis on 14.12.2016.
 */
public class SqlExample {
    private JdbcTemplate jdbcTemplate;

    public SqlExample(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SqlExample() {
    }

    public String sqlInsert() {
        try {
            jdbcTemplate.execute(
                    "INSERT INTO regalia (id," +
                            "name," +
                            "country," +
                            "type," +
                            "year)" +
                            "VALUES( 1," +
                            "'Государственная премия РСФСР'," +
                            "'СССР/Россия'," +
                            "'премия'," +
                            "1976" +
                            ")");

            jdbcTemplate.execute(
                    "INSERT INTO regalia (id," +
                            "name," +
                            "country," +
                            "type," +
                            "year)" +
                            "VALUES( 2," +
                            "'Канский фестиваль'," +
                            "'Франция'," +
                            "'фестиваль'," +
                            "1957" +
                            ")");

            jdbcTemplate.execute("" +
                    "INSERT INTO films (id," +
                    "title," +
                    "date_prod," +
                    "kind," +
                    "regalia_id," +
                    "place)" +
                    "VALUES( 1," +
                    "'Семнадцать мгновений весны'," +
                    "'1973-08-11'," +
                    "'политический детектив - военная драма'," +
                    "1," +
                    "1" +
                    ")");

            jdbcTemplate.execute(
                    "INSERT INTO films (id," +
                    "title," +
                    "date_prod," +
                    "kind," +
                    "regalia_id," +
                    "place)" +
                    "VALUES( 2," +
                    "'Летят журавли'," +
                    "'1957-08-11'," +
                    "'военная драма'," +
                    "2," +
                    "1" +
                    ")");

            jdbcTemplate.execute(
                    "INSERT INTO films (id," +
                            "title," +
                            "date_prod," +
                            "kind," +
                            "regalia_id," +
                            "place)" +
                            "VALUES( 3," +
                            "'Каникулы в Простоквашино'," +
                            "'1957-08-11'," +
                            "'мультфильм'," +
                            "2," +
                            "2" +
                            ")");

            return "Insert SQL operation executed succesfully";
        } catch (Exception e) {
            return "Insert SQL operation failed: " + e;
        }
    }

    private String sqlJoin() {
        try {
            jdbcTemplate.execute("CREATE TABLE films (\n" +
                    "                    code        char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
                    "                    title       varchar(40) NOT NULL,\n" +
                    "                    did         integer NOT NULL,\n" +
                    "                    date_prod   date,\n" +
                    "                    kind        varchar(10),\n" +
                    "                    len         interval hour to minute\n" +
                    "                    )");
            return "Join SQL query executed succesfully";
        } catch (Exception e) {
            return "Join SQL operation failed: " + e;
        }
    }

    private String sqlAttached() {
        try {
            jdbcTemplate.execute("CREATE TABLE films (\n" +
                    "                    code        char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
                    "                    title       varchar(40) NOT NULL,\n" +
                    "                    did         integer NOT NULL,\n" +
                    "                    date_prod   date,\n" +
                    "                    kind        varchar(10),\n" +
                    "                    len         interval hour to minute\n" +
                    "                    )");
            return "Attached SQL query executed succesfully";
        } catch (Exception e) {
            return "Attached SQL query failed: " + e;
        }
    }

    private String sqlCase() {
        try {
            jdbcTemplate.execute("CREATE TABLE films (\n" +
                    "                    code        char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
                    "                    title       varchar(40) NOT NULL,\n" +
                    "                    did         integer NOT NULL,\n" +
                    "                    date_prod   date,\n" +
                    "                    kind        varchar(10),\n" +
                    "                    len         interval hour to minute\n" +
                    "                    )");
            return "Case SQL query executed succesfully";
        } catch (Exception e) {
            return "Case SQL query failed: " + e;
        }
    }


}
