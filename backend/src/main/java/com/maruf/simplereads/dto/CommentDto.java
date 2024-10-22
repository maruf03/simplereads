package com.maruf.simplereads.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class CommentDto {
    private Integer id;
    private Integer userId;
    private Integer reviewId ;
    private String commentText;
    private LocalDateTime createdAt;
}
