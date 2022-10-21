package com.edureka.spring.obrs.category.entity;

import com.edureka.spring.obrs.common.entity.AbstractEntityClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "category")

public class Category extends AbstractEntityClass{

    private String name;
    private String description;

    public Category() {
    }

    public Category(String name, String description) {
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
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
