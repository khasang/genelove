package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateRoles {
    private JdbcTemplate jdbcTemplate;

    public CreateRoles(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateRoles() {

    }

    private String create() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS roles");
            jdbcTemplate.execute("CREATE TABLE roles (\n" +
                    "    role       varchar(40) NOT NULL,\n" +
                    "    person       varchar(40) NOT NULL,\n" +
                    "    filmcode       char(5) PRIMARY KEY\n" +
                    ");");
            return "Table for Roles created";
        } catch (Exception e) {
            return "Table creation failed: " + e;
        }
    }

    public String createRolesStatus () {
        return create();
    }

}


