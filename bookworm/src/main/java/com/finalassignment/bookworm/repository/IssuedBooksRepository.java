package com.finalassignment.bookworm.repository;


import com.finalassignment.bookworm.model.IssuedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuedBooksRepository extends JpaRepository<IssuedBooks,Long> {
}
