package com.finalassignment.bookworm.repository;

import com.finalassignment.bookworm.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
