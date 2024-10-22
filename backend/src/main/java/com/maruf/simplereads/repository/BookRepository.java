package com.maruf.simplereads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maruf.simplereads.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
}
