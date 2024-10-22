package com.maruf.simplereads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maruf.simplereads.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByReviewId(Integer reviewId);
}
