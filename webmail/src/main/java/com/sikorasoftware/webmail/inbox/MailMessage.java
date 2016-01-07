package com.sikorasoftware.webmail.inbox;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by robertsikora on 06.01.2016.
 */
public final class MailMessage implements Serializable {

    @Id
    private String id;

    private final String from;
    @NotNull
    private final Date sentDate;
    private final String subject;
    private final String content;

    public MailMessage(final String from, final Date sentDate, final String subject, final String content) {
        this.from = from;
        this.sentDate = sentDate;
        this.subject = subject;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailMessage that = (MailMessage) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(sentDate, that.sentDate) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, sentDate, subject, content);
    }

    @Override
    public String toString() {
        String sb = "MailMessage{" + "from='" + from + '\'' +
                ", sentDate=" + sentDate +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
        return sb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
