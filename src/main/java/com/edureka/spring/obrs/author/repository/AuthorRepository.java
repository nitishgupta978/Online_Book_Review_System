package com.edureka.spring.obrs.author.repository;


import com.edureka.spring.obrs.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
