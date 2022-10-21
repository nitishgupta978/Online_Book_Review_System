package com.edureka.spring.obrs.book.service;

import com.edureka.spring.obrs.book.entity.Book;
import com.edureka.spring.obrs.common.service.CRUDService;
import com.edureka.spring.obrs.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService extends CRUDService<Book> {
    Page<Book> findAllPageWise(Pageable pageable);

    Page<Book> findAllByPublishers(User publisher, Pageable pageable);

    Page<Book> findAllByCategory(String category, Pageable pageable);

    Page<Book> findAllByAuthor(String category, Pageable pageable);

    Page<Book> findAllByAuthor(Integer authorId, Pageable pageable);
}
