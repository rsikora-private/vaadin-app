package com.sikorasoftware.webmail.inbox;

import java.util.Objects;

/**
 * Created by robertsikora on 09.01.2016.
 */

public class EmailContent {

    public enum ContentType {
        TEXT,
        HTML
    }

    private String content;
    private ContentType contentType;

    public EmailContent(final String content, final ContentType contentType) {
        this.content = content;
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailContent that = (EmailContent) o;
        return Objects.equals(content, that.content) &&
                contentType == that.contentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, contentType);
    }

    @Override
    public String toString() {
        return "EmailContent{" + ", content='" + content + '\'' +
                ", contentType=" + contentType +
                '}';
    }
}
