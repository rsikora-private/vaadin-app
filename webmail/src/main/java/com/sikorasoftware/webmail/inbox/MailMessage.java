package com.sikorasoftware.webmail.inbox;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by robertsikora on 06.01.2016.
 */

@Document(collection = MailMessage.COLLECTION_NAME)
public final class MailMessage implements Serializable {
    final static String COLLECTION_NAME = "mails";

    @Id
    private ObjectId id;

    private String from;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date sentDate;

    private String subject;

    @NotNull
    private Boolean unread = Boolean.TRUE;

    private List<MailContent> content = new ArrayList<>();

    public MailMessage(){
    }

    public MailMessage(final String from, final Date sentDate, final String subject, final List<MailContent> content) {
        this.setFrom(from);
        this.sentDate = sentDate;
        this.setSubject(subject);
        this.content = content;
    }

    public MailMessage(final ObjectId id, final String from, final Date sentDate, final String subject, final Boolean unread, final List<MailContent> content) {
        this.id = id;
        this.from = from;
        this.sentDate = sentDate;
        this.subject = subject;
        this.unread = unread;
        this.content = content;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean isUnread() {
        return unread;
    }

    public void setUnread(Boolean unread) {
        this.unread = unread;
    }

    public String getFrom() {
        return from;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public String getSubject() {
        return subject;
    }

    public List<MailContent> getContent() {
        return content;
    }

    public void setContent(List<MailContent> content){
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailMessage that = (MailMessage) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(sentDate, that.sentDate) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(content, that.content) &&
                Objects.equals(unread, that.unread);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, sentDate, subject, content, unread);
    }

    @Override
    public String toString() {
        String sb = "MailMessage{" + "from='" + from + '\'' +
                ", sentDate=" + sentDate +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", unread='" + unread + '\'' +
                '}';
        return sb;
    }
}
