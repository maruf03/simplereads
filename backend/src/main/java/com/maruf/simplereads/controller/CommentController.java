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

import com.maruf.simplereads.dto.CommentDto;
import com.maruf.simplereads.dto.NewCommentDto;
import com.maruf.simplereads.dto.ResponseDto;
import com.maruf.simplereads.entity.User;
import com.maruf.simplereads.service.CommentService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/comments")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @Operation(summary = "Get All comments by reviews")
    @GetMapping("/{reviewId}")
    public ResponseEntity<ResponseDto<List<CommentDto>>> getAllComments(@PathVariable Integer reviewId) {

        return new ResponseEntity<>(
                new ResponseDto<>(commentService.getAllByReviewId(reviewId), "success", HttpStatus.OK.value()),
                HttpStatus.OK);
    }

    @Operation(summary = "Create a new comment")
    @PostMapping("/create")
    public ResponseEntity<ResponseDto<CommentDto>> createComment(@RequestBody @Valid NewCommentDto newComment) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();
        return new ResponseEntity<>(
                new ResponseDto<>(commentService.create(currentUser.getId(), newComment), "success",
                        HttpStatus.CREATED.value()),
                HttpStatus.CREATED);
    }

}
