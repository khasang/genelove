package io.khasang.genelove.config;

import io.khasang.genelove.model.Message;
import io.khasang.genelove.model.MyMessage;
import io.khasang.genelove.model.SQLExamples;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
public class AppConfig {

    @Autowired
    Environment environment;

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
    public SQLExamples sqlExamples() {
        return new SQLExamples(jdbcTemplate());
    }

    @Bean
    public Message message(){
        return new Message("Hello my bean");
    }

    @Bean
    public MyMessage myMessage() {
        return new MyMessage("This is a new message!");
    }
}
