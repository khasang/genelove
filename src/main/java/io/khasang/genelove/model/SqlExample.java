package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

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
                    "'политический детектив / военная драма'," +
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
            jdbcTemplate.execute(
                    "INSERT INTO films (id," +
                            "title," +
                            "date_prod," +
                            "kind" +
                             ")" +
                            "VALUES( 4," +
                            "'Не выходи из комнаты'," +
                            "'2016-02-01'," +
                            "'приключения / драма'" +
                            ")");

            return "Insert SQL operation executed succesfully";
        } catch (Exception e) {
            return "Insert SQL operation failed: " + e;
        }
    }

    public String sqlJoin() {
        try {
            jdbcTemplate.execute(
                    "SELECT f.title, r.name, r.year FROM films f INNER JOIN regalia r ON f.regalia_id = r.id WHERE f.place = 1"
            );
            return "Join SQL query executed succesfully";
        } catch (Exception e) {
            return "Join SQL operation failed: " + e;
        }
    }

    public String sqlJoin2() {
        try {
            jdbcTemplate.execute(
                    "SELECT f.title, r.name, r.year FROM films f RIGHT OUTER JOIN regalia r ON f.regalia_id = r.id"
            );
            return "Join2 SQL query executed succesfully";
        } catch (Exception e) {
            return "Join SQL operation failed: " + e;
        }
    }

    public String sqlAttached() {
        try {
            jdbcTemplate.execute(
                    "SELECT title FROM films WHERE regalia_id IN (SELECT id FROM regalia WHERE country like '%СССР%')"
                    );
            return "Attached SQL query executed succesfully";
        } catch (Exception e) {
            return "Attached SQL query failed: " + e;
        }
    }

    public String sqlCase() {
        try {
            jdbcTemplate.execute(
                    "SELECT title AS наименование, CASE WHEN place IS NOT NULL THEN 'имеет награды' ELSE 'наградами не отмечен' END AS статус FROM films"
                    );
            return "Case SQL query executed succesfully";
        } catch (Exception e) {
            return "Case SQL query failed: " + e;
        }
    }
}
