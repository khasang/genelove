package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Vasily on 14.12.2016.
 */
public class InsertTable {

    private JdbcTemplate jdbcTemplate;

    public InsertTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public InsertTable() {
    }

    private String insert() {
        try {
            jdbcTemplate.execute("INSERT INTO films (code, title, did, date_prod, kind) VALUES('B6717', 'Tampopo', 110, '1985-02-10', 'Comedy'), ('HG120', 'The Dinner Game', 140, DEFAULT, 'Comedy');");
            return "Data inserted";
        } catch (Exception e) {
            return "Insert failed: " + e;
        }
    }

    public String insertTableStatus() {
        return insert();
    }



}
