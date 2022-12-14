package com.simplishop.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT s FROM Item s WHERE s.id = ?1")
    Optional<Item> findItemById(Long id);
}
