package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class InserData {
    private JdbcTemplate jdbcTemplate;

    public InserData() {
    }

    public InserData(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public String inserData() {
        try {
            jdbcTemplate.execute("INSERT INTO films(code, title, did, date_prod, kind, len)" +
                    " VALUES('film1','Shrek', 2005, '2005-12-12', 'cartoon', '2 hours')");
            jdbcTemplate.execute("INSERT INTO films(code, title, did, date_prod, kind, len)" +
                    " VALUES('film2','Shrek2', 2007, '2007-12-12', 'cartoon', '3 hours')");
            jdbcTemplate.execute("INSERT INTO films(code, title, did, date_prod, kind, len)" +
                    " VALUES('film3','Shrek3', 2008, '2008-12-12', 'cartoon', '1 hours')");
            jdbcTemplate.execute("INSERT INTO teams(id, name, points, owner)" +
                    " VALUES(1,'teamA', 35, 'ownerA')");
            jdbcTemplate.execute("INSERT INTO teams(id, name, points, owner)" +
                    " VALUES(2,'teamB', 33, 'ownerB')");
            jdbcTemplate.execute("INSERT INTO captains(id, team, age, name)" +
                    " VALUES(1, 'teamA', 29, 'captainA')");
            jdbcTemplate.execute("INSERT INTO captains(id, team, age, name)" +
                    " VALUES(2, 'teamB', 29, 'captainB')");
            return "data successfully inserted";
        } catch (Exception e) {
            return "data insertion failed" + e.getMessage();
        }
    }
}
