package com.edureka.spring.obrs.author.entity;


import com.edureka.spring.obrs.common.entity.AbstractEntityClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "author")
public class Author extends AbstractEntityClass {

    private String name;
    private String description;

    public Author() {
    }

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
