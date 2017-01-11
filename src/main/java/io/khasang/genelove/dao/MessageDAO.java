package io.khasang.genelove.dao;

import io.khasang.genelove.entity.Message;

public interface MessageDAO {

    void addMessage(Message message);

    void deleteMessage(Message message);

    //void editMessage(Message message);

    //<Message> getMessageAll();

}
