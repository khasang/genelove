package io.khasang.genelove.service;

import io.khasang.genelove.dao.MessageDAO;
import io.khasang.genelove.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import io.khasang.genelove.dao.UserDAO;
import org.springframework.security.core.context.SecurityContextHolder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class MessageService {

    @Autowired
    MessageDAO messageDAO;

    @Autowired
    UserDAO userDAO;

    public void addMessage(Message message) {
        messageDAO.addMessage(message);
        System.out.println("************* Message Service *************");
        System.out.println("Private Message ID:" + message.getId());
        System.out.println("Private Message Sender:" + message.getSender());
        System.out.println("Private Message Receiver:" + message.getReceiver());
        System.out.println("Private Message Creation Date:" + message.getCreatedDate());
        System.out.println("Private Message Sent Date:" + message.getSentDate());
        System.out.println("Private Message Received Date:" + message.getReceivedDate());
        System.out.println("Private Message Status:" + message.getMessageStatus());
        System.out.println("Private Message Text:" + message.getText());
        System.out.println("*******************************************");
        System.out.println(Calendar.getInstance().getTime());
        //SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

        System.out.println("*******************************************");
   }

    public void deleteMessage(Message message) {
        messageDAO.deleteMessage(message);
    }

    public void editMessage(Message message) {
        messageDAO.editMessage(message);
    }

    public Message getMessageById(int id) {
        return messageDAO.getMessageById(id);
    }

    /*
    public List<Message> getMessageById(int id) {
        List<Message> messages = new ArrayList<>();
        messages.add(messageDAO.getMessageById(id));
        return messages;
    }*/

    public List<Message> getMessagesWith (long id) {
        long otherId = userDAO.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        return messageDAO.getMessagesWith (id, otherId);
    }

    public List<Message> getMessageByKeyWord(String keyWord) {
        return messageDAO.getMessageByKeyWord(keyWord);
    }

    public List<Message> getMessageByDate(String date) {
        return messageDAO.getMessageByDate(date);
    }

    public List<Message> getMessageAll() {
        return messageDAO.getMessageAll();
    }

}
