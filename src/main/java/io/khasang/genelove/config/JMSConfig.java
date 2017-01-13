package io.khasang.genelove.config;

import io.khasang.genelove.service.SimpleMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("example.jms")
public class JMSConfig {
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        return connectionFactory;
    }

    @Bean
    @Autowired
    public DefaultMessageListenerContainer listenerContainer(SimpleMessageListener messageListener){
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setDestinationName("prospring4");
        container.setMessageListener(messageListener);
        return container;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setDefaultDestinationName("prospring4");
        return jmsTemplate;
    }
}
