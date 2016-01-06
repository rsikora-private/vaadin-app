package com.sikorasoftware.webmail.account;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by robertsikora on 04.01.2016.
 */
public class Account implements Serializable {

    @Id
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        String sb = "Account{" + "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", imapHost='" + imapHost + '\'' +
                ", imapPort='" + imapPort + '\'' +
                ", imapSSL=" + imapSSL +
                '}';
        return sb;
    }
}
