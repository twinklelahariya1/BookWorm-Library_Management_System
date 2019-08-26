package com.finalassignment.bookworm.repository;


import com.finalassignment.bookworm.model.BookInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInventoryRepository extends JpaRepository<BookInventory,Long> {
}
