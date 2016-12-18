package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseTraining {
    // jdbc шаблон
    private JdbcTemplate jdbcTemplate;

    // конструкторы
    public DatabaseTraining() {
    }
    public DatabaseTraining(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // методы
    public String trainingStatus() {
        String result = "";
        result += createExampleTables() + "<br>";
        result += fillExampleTables() + "<br>";
        result += leftOuterJoin() + "<br>";
        result += fullOuterJoin() + "<br>";
        result += rightOuterJoin() + "<br>";
        result += innerJoin() + "<br>";
        result += subSelect() + "<br>";
        result += caseWhenThen();
        return result;
    }

    public String createExampleTables() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS example1");
            jdbcTemplate.execute("CREATE TABLE example1 ("
                    + "row_id SERIAL PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "ex2_id INTEGER"
                    + ");");
            jdbcTemplate.execute("DROP TABLE IF EXISTS example2");
            jdbcTemplate.execute("CREATE TABLE example2 ("
                    + "row_id SERIAL PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL"
                    + ");");
            return "Tables successfully created!";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    public String fillExampleTables() {
        try {
            jdbcTemplate.execute("INSERT INTO example1 (name,ex2_id) VALUES"
                    + "('тест1',2),"
                    + "('тест2',6),"
                    + "('тест3',9),"
                    + "('тест4',8),"
                    + "('тест5',1);");
            jdbcTemplate.execute("INSERT INTO example2 (name) VALUES"
                    + "('пролог1'),"
                    + "('пролог2'),"
                    + "('пролог3'),"
                    + "('пролог4'),"
                    + "('пролог5'),"
                    + "('глава1'),"
                    + "('глава2'),"
                    + "('глава3'),"
                    + "('параграф1'),"
                    + "('параграф2');");
            return "Data successfully filled into tables!";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    public String leftOuterJoin() {
        try {
            jdbcTemplate.execute("SELECT * FROM example1 t1 LEFT JOIN example2 t2 ON (t1.ex2_id = t2.row_id);");
            return "Left outer join is executed!";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    public String fullOuterJoin() {
        try {
            jdbcTemplate.execute("SELECT * FROM example1 t1 FULL JOIN example2 t2 ON (t1.ex2_id = t2.row_id);");
            return "Right outer join is executed!";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    public String rightOuterJoin() {
        try {
            jdbcTemplate.execute("SELECT * FROM example1 t1 RIGHT JOIN example2 t2 ON (t1.ex2_id = t2.row_id);");
            return "Right outer join is executed!";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    public String innerJoin() {
        try {
            jdbcTemplate.execute("SELECT * FROM example1 t1 INNER JOIN example2 t2 ON (t1.ex2_id = t2.row_id);");
            return "Inner join is executed!";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    public String subSelect() {
        try {
            jdbcTemplate.execute("SELECT * FROM example2 WHERE row_id IN (SELECT ex2_id FROM example1);");
            return "Select in select is executed!";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    public String caseWhenThen() {
        try {
            jdbcTemplate.execute("SELECT (CASE WHEN name LIKE 'тест%' THEN 'Протестировано' END) as \"name\" FROM example1;");
            return "Conditional expression is executed!";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }
}
