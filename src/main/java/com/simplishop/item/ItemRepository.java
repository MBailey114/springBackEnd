package com.simplishop.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    //@Query("SELECT * FROM Item s WHERE s.category = ?1")
    List<Item> findAllByCategory(String category);
    @Query("SELECT s FROM Item s WHERE s.id = ?1")
    Optional<Item> findItemById(Long id);

    List<Item> findByUserId(Long userId);
}
