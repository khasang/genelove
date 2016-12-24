package io.khasang.genelove.model;
import org.springframework.jdbc.core.JdbcTemplate;
// Class CreateTable 18.12.2016.
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
            //return "Table films created";
        } catch (Exception e) {
            return "Table films creation failed: " + e;
        }
        //

        try {
            jdbcTemplate.execute("drop table if exists params");

            jdbcTemplate.execute("CREATE TABLE params (param_id integer NOT NULL CONSTRAINT pk_param_id PRIMARY KEY ,\n" +
                                                           "param_group_id integer NOT NULL,\n" +
                                                           "description varchar(255));");
            //return "Table films and params created";
        } catch (Exception e) {
            return "Table params creation failed: " + e;
        }

        try {
            jdbcTemplate.execute("drop table if exists params_groups");
            jdbcTemplate.execute("CREATE TABLE params_groups (param_group_id integer NOT NULL CONSTRAINT pk_param_group_id PRIMARY KEY ,\n" +
                                      "description varchar(255));");
            return "Table films ,params & params_groups created";
        } catch (Exception e) {
            return "Table params creation failed: " + e;
        }

    }

    public String createTableStatus() {
        return create();
    }
}
