package com.maruf.simplereads.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class NewReviewDto {
    @NotNull
    private Integer bookId;
    @NotNull
    private Integer rating;
    @NotBlank
    private String reviewText;
}
