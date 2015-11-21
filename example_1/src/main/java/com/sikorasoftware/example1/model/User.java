package com.sikorasoftware.example1.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * Created by robertsikora on 29.10.15.
 */
public class User implements Cloneable {

    private Long id;
    @NotBlank
    private String firstName = "";
    @NotBlank
    private String lastName = "";
    @Phone
    private String phone = "";
    @Email
    private String email = "";

    private Date birthDate;

    public User(){}

    public User(String firstName, Long id, String lastName, String phone, String email, Date birthDate) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        try {
            return new User(this.firstName, id, lastName, phone, email, birthDate);
        } catch (Exception ex) {
            throw new CloneNotSupportedException();
        }
    }
}
