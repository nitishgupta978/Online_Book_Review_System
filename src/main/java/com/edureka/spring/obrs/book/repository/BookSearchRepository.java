package com.edureka.spring.obrs.book.repository;


import com.edureka.spring.obrs.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookSearchRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {
}
