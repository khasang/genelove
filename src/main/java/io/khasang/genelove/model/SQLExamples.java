package io.khasang.genelove.model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class SQLExamples {

    private JdbcTemplate jdbcTemplate;

    public SQLExamples(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String tableCreate() {
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
        } catch (DataAccessException e) {
            return "Table creation failed: " + e;
        }
    }

    public String tableInsert() {
        try {
            jdbcTemplate.execute("INSERT INTO films (code, title, did, date_prod, kind) VALUES\n" +
                    "    ('B6717', 'Tampopo', 110, '1985-02-10', 'Comedy'),\n" +
                    "    ('HG120', 'The Dinner Game', 140, DEFAULT, 'Comedy');");
            return "Records inserted";
        } catch (DataAccessException e) {
            return "Insert failed: " + e;
        }
    }

    public String tableSelect() {
        try {
            jdbcTemplate.execute("SELECT * FROM films");
            return "Records selected";
        } catch (DataAccessException e) {
            return "Select failed: " + e;
        }
    }
}
