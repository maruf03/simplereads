package com.maruf.simplereads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maruf.simplereads.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByBookId(Integer bookId);
}
