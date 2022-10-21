package com.edureka.spring.obrs.book.specification;

import org.springframework.data.jpa.domain.Specification;

public abstract class BaseSpecification<T> {
    private final String wildcard = "%";


    public abstract Specification<T> getFilter(String request);

    protected String containsLowerCase(String searchField) {
        return wildcard + searchField.toLowerCase() + wildcard;
    }


}
