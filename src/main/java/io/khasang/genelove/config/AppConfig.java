package io.khasang.genelove.config;

import io.khasang.genelove.io.khasang.genelove.model.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Руслан on 11.12.2016.
 */

@Configuration
public class AppConfig {

    @Bean
    public Message message() {
        return new Message("Hello my");
    }

}
