package com.maruf.simplereads.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maruf.simplereads.dto.BookDto;
import com.maruf.simplereads.dto.ResponseDto;
import com.maruf.simplereads.service.BookService;

@RestController
@RequestMapping("/books")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @Operation(summary = "Get All books")
    @GetMapping("/all")
    public ResponseEntity<ResponseDto<List<BookDto>>> getAllBooks() {
        return new ResponseEntity<>(new ResponseDto<>(bookService.getAll(), "success", HttpStatus.OK.value()), HttpStatus.OK);
    }

    @Operation(summary = "Get book by Id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<BookDto>> getBookById(@PathVariable Integer id) {
        return new ResponseEntity<>(new ResponseDto<>(bookService.getById(id), "success", HttpStatus.OK.value()), HttpStatus.OK);
    }

    // @Operation(summary = "Create a new book")
    // @GetMapping("/create")
    // public ResponseEntity<ResponseDto<BookDto>> createBook() {

    //     return new ResponseEntity<>(null, HttpStatus.CREATED);
    // }

}