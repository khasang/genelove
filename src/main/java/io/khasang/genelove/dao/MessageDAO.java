package io.khasang.genelove.dao;

import io.khasang.genelove.entity.Message;
import io.khasang.genelove.entity.User;

import java.util.List;

public interface MessageDAO {

    void addMessage(Message message);

    void deleteMessage(Message message);

    void editMessage(Message message);

    Message getMessageById(int id);

    List<Message> getMessagesWith(int id, int otherId);

    List<Message> getMessageByKeyWord(String keyWord);

    List<Message> getMessageByDate(String date);

    List<Message> getMessageAll();

    List<Message> getMessagesFrom(User sender);

    List<Message> getMessagesTo(User recipient);

    List<Message> getMessagesFromTo(User sender, User recipient);

}
