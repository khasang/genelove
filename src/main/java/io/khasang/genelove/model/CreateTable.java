package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Denis on 13.12.2016.
 */
public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    private String create(){
        try{
            jdbcTemplate.execute("DROP TABLE IF EXISTS films");
            jdbcTemplate.execute("CREATE TABLE films (\n" +
                    "                    id          integer CONSTRAINT firstkey PRIMARY KEY,\n" +
                    "                    title       varchar(100) NOT NULL,\n" +
                    "                    date_prod   date,\n" +
                    "                    kind        varchar(50),\n" +
                    "                    regalia_id  integer,\n" +
                    "                    place       integer\n" +
                    "                    )");

            jdbcTemplate.execute("DROP TABLE IF EXISTS regalia");
            jdbcTemplate.execute("CREATE TABLE regalia (\n" +
                    "                    id          integer CONSTRAINT firstkey2 PRIMARY KEY,\n" +
                    "                    name        varchar(100) NOT NULL,\n" +
                    "                    country     varchar(50) NOT NULL,\n" +
                    "                    type        varchar(20),\n" +
                    "                    year        integer\n" +
                    "                    )");

            return  "Tables created";
        } catch (Exception e) {
            return "Tables creation failed: " + e;
        }
    }

    public  String createTableStatus(){
        return create();
    }
}
