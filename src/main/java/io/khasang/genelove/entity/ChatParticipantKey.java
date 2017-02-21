package io.khasang.genelove.entity;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ChatParticipantKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "chat_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "chat_participants_chats_fk"))
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "chat_participants_users_fk"))
    private User participant;

    public ChatParticipantKey() {

    }

    public ChatParticipantKey(Chat chat, User participant) {
        this.chat = chat;
        this.participant = participant;
    }

    public User getParticipant() {
        return participant;
    }

    public void setParticipant(User participant) {
        this.participant = participant;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatParticipantKey that = (ChatParticipantKey) o;

        if (participant != null ? !participant.equals(that.participant) : that.participant != null)
            return false;
        return chat != null ? chat.equals(that.chat) : that.chat == null;
    }

    @Override
    public int hashCode() {
        int result = participant != null ? participant.hashCode() : 0;
        result = 31 * result + (chat != null ? chat.hashCode() : 0);
        return result;
    }
}
