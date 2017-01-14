package io.khasang.genelove.service;

import io.khasang.genelove.dao.MessageDAO;
import io.khasang.genelove.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("MessageService")
@Transactional
public class MessageService {

    @Autowired
    MessageDAO messageDAO;

    public Message getMessageById(int id) {
            return messageDAO.getMessageById(id);
        }
}
