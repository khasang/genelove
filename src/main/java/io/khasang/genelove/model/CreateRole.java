package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateRole {
    private JdbcTemplate jdbcTemplate;

    public CreateRole(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateRole() {

    }

    private String create() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS roles");
            jdbcTemplate.execute("CREATE TABLE cast (\n" +
                    "    role       varchar(40) NOT NULL,\n" +
                    "    person       varchar(40) NOT NULL,\n" +
                    "    filmcode       char(5)\n" +
                    ");");
            return "Table for Cast created";
        } catch (Exception e) {
            return "Table creation failed: " + e;
        }
    }

    public String createRoleStatus () {
        return create();
    }

}


