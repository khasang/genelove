package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * Created by Руслан on 14.12.2016.
 */
public class DataBaseQueries {
    private JdbcTemplate jdbcTemplate;

    public DataBaseQueries(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataBaseQueries() {
    }

    private String select() {
        try {
            jdbcTemplate.execute("INSERT INTO films(code, title, did, date_prod, kind, len)" +
                    " VALUES('film1','Shrek', 2005, '2005-12-12', 'cartoon', '2 hours')");
            jdbcTemplate.execute("SELECT title FROM films \n" +
            "WHERE did = (SELECT max(did) FROM films)");
            String result = jdbcTemplate.queryForObject("SELECT title FROM films \n" +
                    "WHERE did = (SELECT max(did) FROM films)", String.class);
            return "selected item is " + result.toString();
        } catch (Exception e) {
            return "section failed" + e.getMessage();
        }
    }

    public String selectData() {
        return select();
    }
}
