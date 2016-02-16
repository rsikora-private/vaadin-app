package com.sikorasoftware.webmail.account;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by robertsikora on 04.01.2016.
 */

@Document(collection = Account.COLLECTION_NAME)
public final class Account implements Serializable {
    final static String COLLECTION_NAME = "accounts";
    @Id
    private ObjectId id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String imapHost;
    @NotBlank
    private String imapPort;

    private Boolean imapSSL;

    private List<ObjectId> messages = new ArrayList<>();

    private List<Box> boxes = new ArrayList<>();



    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImapHost() {
        return imapHost;
    }

    public void setImapHost(String imapHost) {
        this.imapHost = imapHost;
    }

    public String getImapPort() {
        return imapPort;
    }

    public void setImapPort(String imapPort) {
        this.imapPort = imapPort;
    }

    public Boolean getImapSSL() {
        return imapSSL;
    }

    public void setImapSSL(Boolean imapSSL) {
        this.imapSSL = imapSSL;
    }

    public List<ObjectId> getMessages() {
        return messages;
    }

    public void setMessages(List<ObjectId> messages) {
        this.messages = messages;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(name, account.name) &&
                Objects.equals(email, account.email) &&
                Objects.equals(password, account.password) &&
                Objects.equals(imapHost, account.imapHost) &&
                Objects.equals(imapPort, account.imapPort) &&
                Objects.equals(imapSSL, account.imapSSL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, imapHost, imapPort, imapSSL);
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", imapHost='" + imapHost + '\'' +
                ", imapPort='" + imapPort + '\'' +
                ", imapSSL=" + imapSSL +
                '}';
    }
}
