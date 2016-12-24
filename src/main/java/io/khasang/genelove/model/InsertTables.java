package io.khasang.genelove.model;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertTables {
    private JdbcTemplate jdbcTemplate;

    public InsertTables() {
    }

    public InsertTables(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private String insert() {
        try {
            jdbcTemplate.execute("insert into params values (1,11,'param_1')");
            jdbcTemplate.execute("insert into params values (2,12,'param_2')");
            jdbcTemplate.execute("insert into params values (3,13,'param_3')");
            return "Insert to table params has been succesfully !";
        } catch (Exception e) {
            return "Insert to table params is failed !" + e;
        }
    }
    //
    public String insertTableStatus() {
        return insert();
    }
}
