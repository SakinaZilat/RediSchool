package com.myexperience.service;

import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myexperience.domain.Rating;
import com.myexperience.repository.RatingRepository;

@Service
public class RatingService
{
	@Autowired
	private RatingRepository ratingRepository;
	private final static Logger LOGGER = LoggerFactory.getLogger(RatingService.class);
	public Rating add(Rating rating)
	{
		DateTime dTime=new DateTime(new Date());
		rating.setCreatedDate(dTime.toDate());
		LOGGER.info("The Current Date to Add new User is: "+dTime.toString());
		return this.ratingRepository.save(rating);
	}
	
	public List<Rating> findAll()
	{
		return this.ratingRepository.findAll();
	}

	public List<Rating> findByRatingGreaterThan(int greaterthan){

		return this.ratingRepository.findByRatingGreaterThan(greaterthan);
	}
}
