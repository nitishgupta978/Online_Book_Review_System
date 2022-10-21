package com.edureka.spring.obrs.review.service;
/*
Project : online-book-review-system
IDE     : IntelliJ IDEA
User    : Vijay Gupta
Date    : 31 May 2020
*/

import com.edureka.spring.obrs.book.entity.Book;
import com.edureka.spring.obrs.review.entity.Review;
import com.edureka.spring.obrs.review.entity.ReviewId;
import com.edureka.spring.obrs.user.entity.User;

import java.util.List;

public interface ReviewService{
    List<Review> findAll();
    Review findById(ReviewId reviewId);
    Review saveOrUpdate(Review domainObject);
    void delete(ReviewId reviewId);

    List<Review> findReviewsByBook(Book book);

    List<Review> findAllById(Book book, User user);
}
