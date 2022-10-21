package com.edureka.spring.obrs.book.service;


import com.edureka.spring.obrs.book.entity.Book;
import com.edureka.spring.obrs.book.repository.BookSearchRepository;
import com.edureka.spring.obrs.book.specification.BookSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookSearchServiceImpl implements BookSearchService {
    private final BookSearchRepository bookSearchRepository;
    private final BookSpecification bookSpecification;

    public BookSearchServiceImpl(BookSearchRepository bookSearchRepository, BookSpecification bookSpecification) {
        this.bookSearchRepository = bookSearchRepository;
        this.bookSpecification = bookSpecification;
    }

    @Override
    public Page<Book> searchBooks(String searchKey, Pageable pageable) {
        return this.bookSearchRepository.findAll(bookSpecification.getFilter(searchKey),pageable);
    }
}
