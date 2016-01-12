package com.sikorasoftware.webmail.account;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by robertsikora on 12.01.2016.
 */

@Document(collection = Box.COLLECTION_NAME)
public class Box implements Serializable {

    final static String COLLECTION_NAME = "boxes";

    @NotBlank
    private String name;

    public Box(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Objects.equals(name, box.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
