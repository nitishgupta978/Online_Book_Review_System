package com.edureka.spring.obrs.book.service;


import com.edureka.spring.obrs.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookSearchService {
    Page<Book> searchBooks(String searchKey, Pageable pageable);
}
