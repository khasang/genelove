package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class SelectQuery {
    private JdbcTemplate jdbcTemplate;

    public SelectQuery(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SelectQuery() {
    }

    private String select() {
        try {
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
