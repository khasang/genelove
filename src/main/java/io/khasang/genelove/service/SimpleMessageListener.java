package io.khasang.genelove.service;

import antlr.debug.MessageListener;
import org.apache.activemq.Message;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by Denis on 13.01.2017.
 */
public class SimpleMessageListener implements MessageListener {
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
