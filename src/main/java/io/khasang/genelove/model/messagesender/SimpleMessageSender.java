package io.khasang.genelove.model.messagesender;

import org.apache.activemq.Message;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class SimpleMessageSender implements MessageSender{
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(final String message) {
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
