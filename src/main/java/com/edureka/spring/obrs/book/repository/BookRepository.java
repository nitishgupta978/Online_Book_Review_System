package com.edureka.spring.obrs.book.repository;


import com.edureka.spring.obrs.book.entity.Book;
import com.edureka.spring.obrs.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("FROM #{#entityName} b WHERE b.author.id = ?1 ORDER BY b.isbn ASC")//#{#entityName} will be replaced by Book. Spring does this for us
    Page<Book> findAllByAuthorId(Integer id,Pageable pageable);

    @Query("FROM #{#entityName} b WHERE b.author.name LIKE %?1% ORDER BY b.isbn ASC")
    Page<Book> findAllByAuthorName(String name,Pageable pageable);

    @Query("FROM #{#entityName} b WHERE b.category.id = ?1 ORDER BY b.isbn ASC")
    Page<Book> findAllByCategoryId(Integer id,Pageable pageable);

//    @Query("FROM #{#entityName} b WHERE b.category.name LIKE %?1% ORDER BY b.isbn ASC")
    Page<Book> findAllByCategoryName(String name,Pageable pageable);

    Page<Book> findBooksByPublishers(Pageable pageable, User publishers);
}
