package io.khasang.genelove.config;

import io.khasang.genelove.model.Message;
import io.khasang.genelove.model.NewClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Message message(){
        return new Message("Hello my bean");
    }

    @Bean
    public NewClass message2(){
        return new NewClass("Hello NEW bean");
    }
}
