package com.myexperience.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexperience.domain.Rating;

@Repository("ratingRepository")
public interface RatingRepository extends JpaRepository<Rating, Long>
{

	List<Rating> findByRatingGreaterThan(int ratingGreaterThan);	
	

}

