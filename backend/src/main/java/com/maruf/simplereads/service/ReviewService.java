package com.maruf.simplereads.service;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.maruf.simplereads.dto.NewReviewDto;
import com.maruf.simplereads.dto.ReviewDto;
import com.maruf.simplereads.entity.Review;
import com.maruf.simplereads.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<ReviewDto> getAllByBookId(Integer bookId) {
        return reviewRepository.findAllByBookId(bookId).stream().map(entity -> ReviewDto.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .bookId(entity.getBookId())
                .rating(entity.getRating())
                .reviewText(entity.getReviewText())
                .createdAt(entity.getCreatedAt())
                .build()).toList();
    }

    public ReviewDto getById(Integer id) {
        return reviewRepository.findById(id).map(entity -> ReviewDto.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .bookId(entity.getBookId())
                .rating(entity.getRating())
                .reviewText(entity.getReviewText())
                .createdAt(entity.getCreatedAt())
                .build()).orElse(null);
    }

    public ReviewDto create(Integer userId, NewReviewDto reviewDto) {
        Review newReview = Review.builder()
                .userId(userId)
                .bookId(reviewDto.getBookId())
                .rating(reviewDto.getRating())
                .reviewText(reviewDto.getReviewText())
                .createdAt(LocalDateTime.now())
                .build();
        reviewRepository.save(newReview);
        return ReviewDto.builder()
                .id(newReview.getId())
                .userId(newReview.getUserId())
                .bookId(newReview.getBookId())
                .rating(newReview.getRating())
                .reviewText(newReview.getReviewText())
                .createdAt(newReview.getCreatedAt())
                .build();
    }
}
