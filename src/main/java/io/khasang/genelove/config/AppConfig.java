package io.khasang.genelove.config;

import io.khasang.genelove.model.CreateTable;
import io.khasang.genelove.model.Message;
import io.khasang.genelove.model.NewClass;
import io.khasang.genelove.model.SqlExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import java.util.Properties;

@Configuration
@PropertySource(value = {"classpath:util.properties"})
@PropertySource(value = {"classpath:auth.properties"})
@PropertySource(value = {"classpath:email.properties"})
public class AppConfig {
    @Autowired
    Environment environment;

    @Bean
    public Message message(){
        return new Message("Hello my bean");
    }

    @Bean
    public NewClass message2(){
        return new NewClass("Hello NEW bean");
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.postgresql.driverClass"));
        dataSource.setUrl(environment.getProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public CreateTable createTable(){
        return new CreateTable(jdbcTemplate());
    }

    @Bean
    public SqlExample sqlExample(){
        return new SqlExample(jdbcTemplate());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
        jdbcImpl.setDataSource(dataSource());
        jdbcImpl.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery"));
        jdbcImpl.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
        return jdbcImpl;
    }


    /** E-mail server settings for sending e-mail message to client" */
    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getProperty("mail.smtp.host"));
        mailSender.setPort(Integer.parseInt(environment.getProperty("mail.smtp.port")));
        mailSender.setUsername(environment.getProperty("mail.username"));
        mailSender.setPassword(environment.getProperty("mail.password"));

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", environment.getProperty("mail.smtp.starttls.enable"));
        javaMailProperties.put("mail.smtp.auth", environment.getProperty("mail.smtp.auth"));
        javaMailProperties.put("mail.transport.protocol", environment.getProperty("mail.transport.protocol"));
        javaMailProperties.put("mail.smtp.socketFactory.class", environment.getProperty("mail.smtp.socketFactory.class"));
        javaMailProperties.put("mail.smtp.socketFactory.fallback", environment.getProperty("mail.smtp.socketFactory.fallback"));
        javaMailProperties.put("mail.debug", environment.getProperty("mail.debug"));//Prints out everything on screen

        mailSender.setJavaMailProperties(javaMailProperties);

        return mailSender;
    }
}
