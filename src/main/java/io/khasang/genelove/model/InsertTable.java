package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class InsertTable {
    private JdbcTemplate jdbcTemplate;

    public InsertTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public InsertTable() {
    }

    private String insert () {
        try {
            jdbcTemplate.execute ("INSERT INTO films " +
                    "(code, title, did, date_prod, kind) VALUES\n" +
                    "('B6717', 'Tampopo', 110, '1985-02-10', 'Comedy'),\n" +
                    "('SA239', 'Sacramento', 190, '19959-09-10', 'Comedy'),\n" +
                    "('UN026', 'Sherloc Holmes', 10, '2008-12-10', 'Detective'),\n" +
                    "('HG120', 'The Dinner Game', 140, DEFAULT, 'Comedy');");

            return "Data were inserted into table films";
        }
        catch (Exception e) {
            return "Data insert into films failed: " + e;
        }

    }

    public String insertTableStatus () {
        return insert();
    }
}
