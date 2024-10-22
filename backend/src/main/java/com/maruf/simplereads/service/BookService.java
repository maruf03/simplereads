package com.maruf.simplereads.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maruf.simplereads.dto.BookDto;
import com.maruf.simplereads.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<BookDto> getAll() {
        return bookRepository.findAll().stream().map(entity -> BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .publishedDate(entity.getPublishedDate())
                .coverImageUrl(entity.getCoverImageUrl())
                .build()).toList();
    }

    public BookDto getById(Integer id) {
        return bookRepository.findById(id).map(entity -> BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .publishedDate(entity.getPublishedDate())
                .coverImageUrl(entity.getCoverImageUrl())
                .build()).orElse(null);
    }

}
