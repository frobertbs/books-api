package com.engfrobert.books_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engfrobert.books_api.domain.BookEntity;
@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
    // Custom query methods can be defined here if needed

}
