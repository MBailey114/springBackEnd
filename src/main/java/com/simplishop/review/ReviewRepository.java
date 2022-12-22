package com.simplishop.review;

import com.simplishop.item.Item;
import com.simplishop.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.simplishop.review.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByItemAndUser(Item item, UserEntity user);

    List<Review> findByItem(Item item);

    List<Review> findByUser(UserEntity user);
}
