package com.maruf.simplereads.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
@Builder
@ToString
public class Book {
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String isbn;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column(name = "cover_image_url")
    private String coverImageUrl;
}
