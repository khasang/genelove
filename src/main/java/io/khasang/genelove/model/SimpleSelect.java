package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class SimpleSelect {
    private JdbcTemplate jdbcTemplate;

    public SimpleSelect(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SimpleSelect() {
    }

    private String simpleSelect () {
        try {
            String result = jdbcTemplate.queryForObject
                    ("SELECT title FROM films WHERE did = (SELECT max(did) FROM films)", String.class);
            return "result: " + result.toString();
        }
        catch (Exception e) {
            return "Data simple select from films failed: " + e;
        }
    }

    public String simpleSelectTableStatus () {
        return simpleSelect();
    }
}
