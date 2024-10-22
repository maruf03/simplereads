package com.maruf.simplereads.service;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.maruf.simplereads.dto.CommentDto;
import com.maruf.simplereads.dto.NewCommentDto;
import com.maruf.simplereads.entity.Comment;
import com.maruf.simplereads.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<CommentDto> getAllByReviewId(Integer reviewId) {
        return commentRepository.findAllByReviewId(reviewId).stream().map(entity -> CommentDto.builder()
                .id(entity.getId())
                .reviewId(entity.getReviewId())
                .userId(entity.getUserId())
                .commentText(entity.getCommentText())
                .createdAt(entity.getCreatedAt())
                .build()).toList();
    }

    public CommentDto getById(Integer id) {
        return commentRepository.findById(id).map(entity -> CommentDto.builder()
                .id(entity.getId())
                .reviewId(entity.getReviewId())
                .userId(entity.getUserId())
                .commentText(entity.getCommentText())
                .createdAt(entity.getCreatedAt())
                .build()).orElse(null);
    }

    public CommentDto create(Integer userId, NewCommentDto commentDto) {
        Comment newComment = Comment.builder()
                .userId(userId)
                .reviewId(commentDto.getReviewId())
                .commentText(commentDto.getCommentText())
                .createdAt(LocalDateTime.now())
                .build();
        commentRepository.save(newComment);
        return CommentDto.builder()
                .id(newComment.getId())
                .userId(newComment.getUserId())
                .reviewId(newComment.getReviewId())
                .commentText(newComment.getCommentText())
                .createdAt(newComment.getCreatedAt())
                .build();
    }
}
