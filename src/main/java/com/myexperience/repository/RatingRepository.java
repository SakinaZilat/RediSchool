package com.myexperience.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexperience.domain.Rating;

import java.util.List;

@Repository("ratingRepository")
public interface RatingRepository extends JpaRepository<Rating, Long>
{
    List<Rating> findByRatingGreaterThan(int rating);
}

