package com.myexperience.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexperience.domain.Rating;
import com.myexperience.repository.RatingRepository;


@Service
public class RatingService
{
	@Autowired
	private RatingRepository ratingRepository;
	
	public Rating add(Rating rating)
	{
		return this.ratingRepository.save(rating);
	}
	
	public List<Rating> findAll()
	{
		return this.ratingRepository.findAll();
	}

	

	public List<Rating> findRatingGreaterThan(int ratingGreaterThan) {
		
		return this.ratingRepository.findByRatingGreaterThan(ratingGreaterThan);
	}
	
	
	
}
