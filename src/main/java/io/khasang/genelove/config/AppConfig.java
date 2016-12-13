package io.khasang.genelove.config;

import io.khasang.genelove.model.LembergMessage;
import io.khasang.genelove.model.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Message message(){
        return new Message("Hello my bean");
    }

    @Bean
    public LembergMessage lembergMessage(){
        return new LembergMessage();
    }

}
