package com.edureka.spring.obrs.common.service;

import com.edureka.spring.obrs.error.exceptions.NotFoundException;

import java.util.List;

public interface CRUDService<T> {
    List<?> findAll();
    T findById(Integer id) throws NotFoundException;
    T saveOrUpdate(T domainObject);
    void deleteById(Integer id);
}
