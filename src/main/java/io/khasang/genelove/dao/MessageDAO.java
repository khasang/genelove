package io.khasang.genelove.dao;

import io.khasang.genelove.entity.Message;

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

}
