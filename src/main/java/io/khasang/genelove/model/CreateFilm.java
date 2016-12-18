package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateFilm {
    private JdbcTemplate jdbcTemplate;

    public CreateFilm(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateFilm() {

    }

    private String create() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS films");
            jdbcTemplate.execute("CREATE TABLE films (\n" +
                    "    filmcode        char(5) CONSTRAINT firstkey PRIMARY KEY,\n" +
                    "    title       varchar(40) NOT NULL,\n" +
                    "    date_prod   date,\n" +
                    "    kind        varchar(10),\n" +
                    "    len         interval hour to minute\n" +
                    ");");
            return "Table for Films created";
        } catch (Exception e) {
            return "Table creation failed: " + e;
        }
    }

    public String createFilmStatus () {
        return create();
    }

}


