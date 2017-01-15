package io.khasang.genelove.service;

import io.khasang.genelove.dao.MessageDAO;
import io.khasang.genelove.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class MessageService {

    @Autowired
    MessageDAO messageDAO;

    public void addMessage(Message message) {
        messageDAO.addMessage(message);
    }

    public void deleteMessage(Message message) {
        messageDAO.deleteMessage(message);
    }

    public void editMessage(Message message) {
        messageDAO.editMessage(message);
    }

    public List<Message> getMessageById(int id) {
        List<Message> messages = new ArrayList<>();
        messages.add(messageDAO.getMessageById(id));
        return messages;
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
