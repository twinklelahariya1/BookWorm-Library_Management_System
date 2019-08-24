package com.finalassignment.bookworm.repository;

import com.finalassignment.bookworm.model.UserLibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserLibraryCardRepository extends JpaRepository<UserLibraryCard,Long> {
}
