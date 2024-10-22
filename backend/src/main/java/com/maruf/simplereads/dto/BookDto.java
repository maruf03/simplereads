package com.maruf.simplereads.dto;

import java.time.LocalDate;

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
public class BookDto {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate ;
    private String coverImageUrl;
}
