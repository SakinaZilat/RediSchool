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

import com.myexperience.domain.Experience;
import com.myexperience.service.ExperienceService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/{version}/myexperience", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExperienceController
{
	@Autowired
	private ExperienceService experienceService;
	
	
	@RequestMapping(value = "/experiences", method = RequestMethod.GET)
	public ResponseEntity<List<Experience>> getAllExperiences(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version
			)
	{
		List<Experience> experienceList = experienceService.findAll();
		return new ResponseEntity<>(experienceList, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/experience", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Experience create(@RequestBody Experience experience, @ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version)
	{
		return experienceService.add(experience);
		
	}

	@RequestMapping(value = "/experience/lastDays/{filterDate}", method = RequestMethod.GET)
	public ResponseEntity<List<Experience>> allExperienceCreatedLastWeek(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(name = "filterDate",defaultValue ="7")@PathVariable("filterDate") int filterDate
	)
	{
		List<Experience> experienceListForLastWeek = experienceService.findByStartDateAfter(filterDate);
		return new ResponseEntity<>(experienceListForLastWeek, HttpStatus.OK);
	}

}
