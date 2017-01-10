package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CaseQuery {
    JdbcTemplate jdbcTemplate;

    public CaseQuery() {
    }

    public CaseQuery(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private String query() {
        try {
            Integer len = jdbcTemplate.queryForObject("SELECT CASE " +
                    "WHEN avg(did) IS NULL THEN max(did) ELSE min(did) END FROM films", Integer.class);
            return len.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String caseQuery() {
        return query();
    }
}
