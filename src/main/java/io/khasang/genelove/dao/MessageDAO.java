package io.khasang.genelove.dao;

import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.User;

import java.util.List;

public interface MessageDAO {

    void addMessage(Message message);

    void deleteMessage(Message message);

    void editMessage(Message message);

    Message getMessageById(long id);

    List<Message> getMessagesWith(long id, long otherId);

    List<Message> getMessageByKeyWord(String keyWord);

    List<Message> getMessageByDate(String date);

    List<Message> getMessageAll();

    List<Message> getMessagesFrom(User sender);

    List<Message> getMessagesTo(User recipient);

    List<Message> getMessagesFromTo(User sender, User recipient);

}
