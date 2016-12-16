package io.khasang.genelove.model;


import io.khasang.genelove.constants.SqlConstns;
import org.springframework.jdbc.core.JdbcTemplate;

public class SQLTable {

    private JdbcTemplate jdbcTemplate;

    public SQLTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SQLTable() {
    }

    public String createTable(){
        try {
            jdbcTemplate.execute(SqlConstns.DROP_TABLE_FILMS);
            jdbcTemplate.execute(SqlConstns.DROP_TABLE_USER);
            jdbcTemplate.execute(SqlConstns.CREATE_TABLE_USERS);
            jdbcTemplate.execute(SqlConstns.CREATE_TABLE_FILMS);
            return "SUCCESS";
        }
        catch (Exception e){
          return   "FAILED (reason : " + e +" )";
        }
    }

    public String insertTable(){
        try {
            jdbcTemplate.execute("insert into films (id, title) values (1, 'Love')");
            jdbcTemplate.execute("insert into films (id, title) values (2, 'Angry Birds')");
            jdbcTemplate.execute("insert into films (id, title) values (3, 'Gravitation')");
            jdbcTemplate.execute("insert into films (id, title) values (4, 'Java in action')");
            jdbcTemplate.execute("insert into films (id, title) values (5, 'Batman')");

            jdbcTemplate.execute("insert into users (id, name,id_film) values (1, 'Anton',2)");
            jdbcTemplate.execute("insert into users (id, name,id_film) values (2, 'Borys',4)");
            jdbcTemplate.execute("insert into users (id, name,id_film) values (3, 'Valera',4)");
            jdbcTemplate.execute("insert into users (id, name,id_film) values (4, 'Ivan',5)");
            jdbcTemplate.execute("insert into users (id, name,id_film) values (5, 'Olena',3)");

            jdbcTemplate.execute("SELECT u.id, u.name, f.title AS film_watch " +
                    "FROM users u " +
                    "INNER JOIN films f ON u.id_film = f.id");

            return "SUCCESS";
        }catch (Exception e){
            return "FAILED (reason : " + e +" )";
        }
    }


}
