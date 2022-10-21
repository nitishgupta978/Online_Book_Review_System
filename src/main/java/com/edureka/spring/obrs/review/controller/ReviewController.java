package com.edureka.spring.obrs.review.controller;
/*
Project : online-book-review-system
IDE     : IntelliJ IDEA
User    : Vijay Gupta
Date    : 19 June 2020
*/

import com.edureka.spring.obrs.book.entity.Book;
import com.edureka.spring.obrs.book.service.BookService;
import com.edureka.spring.obrs.common.utils.CommonUtil;
import com.edureka.spring.obrs.common.utils.LogUtil;
import com.edureka.spring.obrs.review.entity.Review;
import com.edureka.spring.obrs.review.entity.ReviewId;
import com.edureka.spring.obrs.review.service.ReviewService;
import com.edureka.spring.obrs.user.entity.User;
import com.edureka.spring.obrs.user.security.UserDetailsImpl;
import com.edureka.spring.obrs.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final String CLASS_NAME = this.getClass().getName();

    private ReviewService reviewService;
    private BookService bookService;
    private UserService userService;

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id")
    public String findReviewsByBook(@AuthenticationPrincipal UserDetailsImpl user, @RequestParam(defaultValue = "0") Integer id, Model model) {
        LogUtil.logDebug(LOG, CLASS_NAME, "findReviewsByBook", "user.getUsername() = " + user.getUsername() + ", id = " + id);

        Book bookDetail = this.bookService.findById(id);

        User byUsername = this.userService.findByUsername(user.getUsername());

        List<Review> allById = this.reviewService.findReviewsByBook(bookDetail);
        CommonUtil.ratingCalculate(allById, model);

        model.addAttribute("bookDetail", bookDetail);
        model.addAttribute("reviews", allById);
        return "bookDetail";
    }

    @PostMapping("/save")
    public String save(@AuthenticationPrincipal UserDetailsImpl user, @RequestParam("bookId") Integer bookId, @ModelAttribute("review") Review review, Model model) {
        LogUtil.logDebug(LOG, CLASS_NAME, "save", "user.getUsername() = " + user.getUsername() + ", bookId = " + bookId + ", review = " + review);

        Book book = this.bookService.findById(bookId);
        User byUsername = this.userService.findByUsername(user.getUsername());

        ReviewId reviewId = new ReviewId(book, byUsername);
        review.setId(reviewId);
        this.reviewService.saveOrUpdate(review);

        return "redirect:/book/bookDetail/?id=" + bookId;
    }

    @GetMapping("/delete")
    public String delete(ReviewId reviewId) {
        this.reviewService.delete(reviewId);
        return "redirect:/book/bookDetail";
    }
}
