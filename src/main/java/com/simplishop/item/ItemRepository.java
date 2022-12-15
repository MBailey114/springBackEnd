package com.simplishop.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

//    @Query("SELECT * FROM Item WHERE category = ?1")
//    Optional<Item> findItembyCategory(String category);

    @Query("SELECT s FROM Item s WHERE s.id = ?1")
    Optional<Item> findItemById(Long id);
}
