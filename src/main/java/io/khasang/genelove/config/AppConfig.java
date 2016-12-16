package io.khasang.genelove.config;

import io.khasang.genelove.model.LembergMessage;
import io.khasang.genelove.model.Message;
import io.khasang.genelove.model.SQLTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
public class AppConfig {

    @Autowired
    Environment environment;

    @Bean
    public Message message(){
        return new Message("Hello my bean");
    }

    @Bean
    public LembergMessage lembergMessage(){
        return new LembergMessage();
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public SQLTable sqlTable(){
       return new SQLTable(jdbcTemplate());
    }
}
