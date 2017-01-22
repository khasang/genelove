package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/* This Entity represents the e-mail letter.
* Short description for fields of this Entity:
* - Id: it's a identificator for e-mail (I think, that this Id must be unique, probably ...
* - Recipient: someone for whom this e-mail is sending. Here recipients represent via his/her email address.
*   Recipient may be single or multiple, simple for one recipient and multiple for group of recipients.
* - Sender: someone, who sending this e-mail. Here sender represents via his/her email address.
*   Sender may be alone only. Here is a "genelove@mail.ru".
* - Subject: Subject is the subject of e-Mail. It's easy :-)
* - Text: Text is the text of e-Mail. It's easy :-)
*/

@Entity(name = "email")
public class EMail {
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 9999)
    private String recipient;

    @Column(length = 500)
    private String sender;

    @Column(length = 9999)
    private String subject;

    @Column(length = 9999)
    private String text;

    @Column(name = "creation_time")
    private Date creationTime;

    public EMail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public EMail(EMail eMail) {
        this.setRecipient(eMail.getRecipient());
        this.setSender(eMail.getSender());
        this.setSubject(eMail.getSubject());
        this.setText(eMail.getText());
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public EMail(String recipient, String sender, String subject, String text) {
        this.setRecipient(recipient);
        this.setSender(sender);
        this.setSubject(subject);
        this.setText(text);
    }

    public EMail( String sender, String subject, String text) {
        this.setRecipient(null);
        this.setSender(sender);
        this.setSubject(subject);
        this.setText(text);
    }
}
