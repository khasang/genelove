package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    private String create () {
        try {
            jdbcTemplate.execute ("drop table if exists films");
            jdbcTemplate.execute ("CREATE TABLE films (\n" +
                    "    code        char(5),\n" +
                    "    title       varchar(40),\n" +
                    "    did         integer,\n" +
                    "    date_prod   date,\n" +
                    "    kind        varchar(10),\n" +
                    "    len         interval hour to minute,\n" +
                    "    CONSTRAINT production UNIQUE(date_prod)\n" +
                    ");");
            return "Table created";
        }
        catch (Exception e) {
            return "Table creation failed: " + e;
        }
    }

    public String createTableStatus () {
        return create();
    }
}
