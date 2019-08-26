package com.finalassignment.bookworm.repository;


import com.finalassignment.bookworm.model.BookInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookInventoryRepository extends JpaRepository<BookInventory,Long> {

//    @Query("select a.book_id from inventory a")
//    BookInventory deleteBookFromInventory(Long book_id);
}

