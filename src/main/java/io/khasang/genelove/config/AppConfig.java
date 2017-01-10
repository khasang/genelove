package io.khasang.genelove.config;

import io.khasang.genelove.model.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
@PropertySource(value = {"classpath:auth.properties"})
public class AppConfig {
    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        dataSource.setInitialSize(1);
        dataSource.setMaxTotal(5);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource());
        jdbcDao.setUsersByUsernameQuery(environment.getProperty("usersByQuery"));
        jdbcDao.setAuthoritiesByUsernameQuery(environment.getProperty("rolesByQuery"));
        return jdbcDao;
    }

    @Bean
    public CreateTable createTable() {
        return new CreateTable(jdbcTemplate());
    }

    @Bean
    public SelectQuery dataBaseQueries() {
        return  new SelectQuery(jdbcTemplate());
    }

    @Bean
    public CaseQuery caseQuery() {
        return new CaseQuery(jdbcTemplate());
    }

    @Bean
    public InserData inserData() {
        return new InserData(jdbcTemplate());
    }

    @Bean
    public JoinQuery joinQuery() {
        return new JoinQuery(jdbcTemplate());
    }
}