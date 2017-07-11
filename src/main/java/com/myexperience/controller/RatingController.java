package com.myexperience.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myexperience.domain.Rating;
import com.myexperience.service.RatingService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/{version}/myexperience", produces = MediaType.APPLICATION_JSON_VALUE)
public class RatingController
{
	@Autowired
	private RatingService ratingService;

	@RequestMapping(value = "/ratings", method = RequestMethod.GET)
	public ResponseEntity<List<Rating>> getAllRatings(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version
			)
	{
		List<Rating> ratingList = ratingService.findAll();
		return new ResponseEntity<>(ratingList, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/rating", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Rating create(@RequestBody Rating rating, @ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version)
	{
		return ratingService.add(rating);
	}
	@RequestMapping(value = "/rating/Graterthan", method = RequestMethod.GET)
	public ResponseEntity<List<Rating>> getRatingGraterThan3(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(name = "Graterthan", defaultValue ="3") @PathVariable("Graterthan") int Graterthan
	)
	{
		List<Rating> ratingList = ratingService.findByRatingGreaterThan(Graterthan);
		return new ResponseEntity<>(ratingList, HttpStatus.OK);
	}

}
