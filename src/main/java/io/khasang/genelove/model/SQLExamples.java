package io.khasang.genelove.model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class SQLExamples {

    private JdbcTemplate jdbcTemplate;

    public SQLExamples(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String tableDelete() {
        try {
            // Drop tables
            jdbcTemplate.execute("DROP TABLE IF EXISTS revenue CASCADE;");
            jdbcTemplate.execute("DROP TABLE IF EXISTS countries CASCADE;");
            jdbcTemplate.execute("DROP TABLE IF EXISTS films CASCADE;");

            return "Tables deleted";
        } catch (DataAccessException e) {
            return "Table deletion failed: " + e;
        }
    }

    public String tableCreate() {
        try {
            // Create table Films
            jdbcTemplate.execute("CREATE TABLE films (\n" +
                    "    code        char(5) CONSTRAINT primary_key_films PRIMARY KEY,\n" +
                    "    title       varchar(40) NOT NULL,\n" +
                    "    did         integer NOT NULL,\n" +
                    "    date_prod   date,\n" +
                    "    kind        varchar(10),\n" +
                    "    len         interval hour to minute);");

            // Create table Countries
            jdbcTemplate.execute("CREATE TABLE countries (\n" +
                    "    code         char(2) CONSTRAINT primary_key_countries PRIMARY KEY,\n" +
                    "    country_name varchar(50) NOT NULL);");

            // Create table Revenue
            jdbcTemplate.execute("CREATE TABLE revenue (\n" +
                    "    film_code    char(5) NOT NULL,\n" +
                    "    country_code char(2) NOT NULL,\n" +
                    "    revenue      integer NOT NULL,\n" +
                    "    CONSTRAINT pk_revenue PRIMARY KEY (film_code, country_code),\n" +
                    "    CONSTRAINT fk_countries FOREIGN KEY (country_code) REFERENCES countries(code),\n" +
                    "    CONSTRAINT fk_films FOREIGN KEY (film_code) REFERENCES films(code));");

            return "Tables created";
        } catch (DataAccessException e) {
            return "Table creation failed: " + e;
        }
    }

    public String tableInsert() {
        try {
            // Insert into Films
            jdbcTemplate.execute("INSERT INTO films (code, title, did, date_prod, kind) VALUES\n" +
                    "    ('B6717', 'Tampopo', 110, '1985-02-10', 'Comedy'),\n" +
                    "    ('HG120', 'The Dinner Game', 140, DEFAULT, 'Comedy');");

            // Insert into Countries
            jdbcTemplate.execute("INSERT INTO countries (code, country_name) VALUES\n" +
                    "    ('RU', 'Russian Federaton'),\n" +
                    "    ('US', 'United States of America'),\n" +
                    "    ('GB', 'United Kingdom'),\n" +
                    "    ('DE', 'Germany'),\n" +
                    "    ('IT', 'Italy');");

            // Insert into Revenue
            jdbcTemplate.execute("INSERT INTO revenue (film_code, country_code, revenue) VALUES\n" +
                    "    ('B6717', 'RU', 500000),\n" +
                    "    ('HG120', 'RU', 1200000),\n" +
                    "    ('B6717', 'US', 1500000),\n" +
                    "    ('HG120', 'GB', 480000),\n" +
                    "    ('B6717', 'DE', 390000),\n" +
                    "    ('HG120', 'DE', 1000000);");

            return "Records inserted";
        } catch (DataAccessException e) {
            return "Insert failed: " + e;
        }
    }

    public String tableSelect() {
        try {
            // Select from Films
            jdbcTemplate.execute("SELECT * FROM films");

            // Select from Films
            jdbcTemplate.execute("SELECT * FROM countries");

            // Select from Films
            jdbcTemplate.execute("SELECT * FROM revenue");

            // Select all films with non-null revenue ordered by revenue descending
            jdbcTemplate.execute("SELECT f.title, c.country_name, r.revenue \n" +
                    " FROM revenue AS r \n" +
                    " INNER JOIN countries AS c ON r.country_code = c.code \n" +
                    " INNER JOIN films AS f ON r.film_code = f.code \n" +
                    " ORDER BY revenue DESC;");

            // Subqueries
            jdbcTemplate.execute("SELECT * FROM revenue \n" +
                    " WHERE film_code IN (SELECT code FROM films);");

            jdbcTemplate.execute("SELECT * FROM countries \n" +
                    " WHERE EXISTS (SELECT country_code FROM revenue WHERE country_code = countries.code);");

            // Case
            jdbcTemplate.execute("SELECT CASE WHEN revenue < 1000000 THEN 0 ELSE revenue END AS revenue \n" +
                    " FROM revenue;");

            return "Records selected";
        } catch (DataAccessException e) {
            return "Select failed: " + e;
        }
    }
}
