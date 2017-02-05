package io.khasang.genelove.service;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.model.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final UserWrapper userWrapper) {

        jmsTemplate.send(new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException {
//                ObjectMessage objectMessage = session.createObjectMessage(userWrapper);
//                return objectMessage;
                return session.createTextMessage(userWrapper.toString());
            }
        });
    }
}
