package com.app.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by amits on 21/01/15.
 */
@Entity
public class Messege {

    @Id
    @GeneratedValue
    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "message_text")
    private String messageText;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messege messege = (Messege) o;

        if (messageId != null ? !messageId.equals(messege.messageId) : messege.messageId != null) return false;
        if (messageText != null ? !messageText.equals(messege.messageText) : messege.messageText != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId != null ? messageId.hashCode() : 0;
        result = 31 * result + (messageText != null ? messageText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "messageId=" + messageId +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
