package io.khasang.genelove.entity;

import javax.persistence.*;

@Entity(name = "chat_paticipants")
public class ChatParticipant {

    public enum ParticipantRole {
        PARTICIPANT, HOST
    }

    @EmbeddedId
    private ChatParticipantKey chatParticipantKey;

    @Column(name = "participant_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private ParticipantRole participantRole;

    @OneToOne
    @JoinColumn(name = "message_last_read_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "chat_participants_chat_messages_fk"))
    private ChatMessage messageLastRead;

    public ChatParticipant() {

    }

    public ChatParticipant(Chat chat, User participant) {
        this.chatParticipantKey = new ChatParticipantKey(chat, participant);
        this.participantRole = ParticipantRole.PARTICIPANT;
    }

    public void setChatParticipantKey(ChatParticipantKey chatParticipantKey) {
        this.chatParticipantKey = chatParticipantKey;
    }

    public ChatParticipantKey getChatParticipantKey() {
        return chatParticipantKey;
    }

    public ParticipantRole getParticipantRole() {
        return participantRole;
    }

    public void setParticipantRole(ParticipantRole participantRole) {
        this.participantRole = participantRole;
    }

    public ChatMessage getMessageLastRead() {
        return messageLastRead;
    }

    public void setMessageLastRead(ChatMessage messageLastRead) {
        this.messageLastRead = messageLastRead;
    }
}
