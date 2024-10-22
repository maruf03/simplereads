package com.maruf.simplereads.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maruf.simplereads.dto.NewReviewDto;
import com.maruf.simplereads.dto.ResponseDto;
import com.maruf.simplereads.dto.ReviewDto;
import com.maruf.simplereads.entity.User;
import com.maruf.simplereads.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/reviews")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @Operation(summary = "Get All reviews by book")
    @GetMapping("/{bookId}")
    public ResponseEntity<ResponseDto<List<ReviewDto>>> getAllReviews(@PathVariable Integer bookId) {

        return new ResponseEntity<>(
                new ResponseDto<>(reviewService.getAllByBookId(bookId), "success", HttpStatus.OK.value()),
                HttpStatus.OK);
    }

    @Operation(summary = "Create a new review")
    @PostMapping("/create")
    public ResponseEntity<ResponseDto<ReviewDto>> createReview(@RequestBody @Valid NewReviewDto newReview) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();
        return new ResponseEntity<>(
                new ResponseDto<>(reviewService.create(currentUser.getId(), newReview), "success",
                        HttpStatus.CREATED.value()),
                HttpStatus.CREATED);
    }
}
