package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
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
            jdbcTemplate.execute("DROP TABLE IF EXISTS teams");
            jdbcTemplate.execute("CREATE TABLE teams (\n" +
                    "    id          integer,\n" +
                    "    name        varchar(40) NOT NULL,\n" +
                    "    points      integer NOT NULL,\n" +
                    "    owner       varchar(40)\n" +
                    ");");
            jdbcTemplate.execute("DROP TABLE IF EXISTS captains");
            jdbcTemplate.execute("CREATE TABLE captains (\n" +
                    "    id          integer,\n" +
                    "    team        varchar(40) NOT NULL,\n" +
                    "    age         integer NOT NULL,\n" +
                    "    name        varchar(40)\n" +
                    ");");
            return "Table created";
        } catch (Exception e) {
            return "Table creation failed: " + e.getMessage();
        }
    }

    public String createTableStatus() {
        return create();
    }
}