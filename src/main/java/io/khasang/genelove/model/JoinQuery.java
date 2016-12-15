package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JoinQuery {
    JdbcTemplate jdbcTemplate;

    public JoinQuery() {
    }

    public JoinQuery(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public List join() {
        try {
            List list = jdbcTemplate.queryForList("SELECT * FROM teams INNER JOIN captains " +
                    "ON (public.teams.id = public.captains.id)");
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
