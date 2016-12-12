package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public  CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    public CreateTable() {

    }

    private String create() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS films");
            jdbcTemplate.execute("CREATE TABLE films (\n" +
                    "    code        char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
                    "    title       varchar(40) NOT NULL,\n" +
                    "    did         integer NOT NULL,\n" +
                    "    date_prod   date,\n" +
                    "    kind        varchar(10),\n" +
                    "    len         interval hour to minute\n" +
                    ");");
            return "Table created";
        } catch (Exception e) {
            return "Table creation failed: " + e;
        }

    }

    public String createTableStatus () {
        return create();
    }

}


