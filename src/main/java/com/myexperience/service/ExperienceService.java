package com.myexperience.service;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexperience.domain.CategoryType;
import com.myexperience.domain.Experience;
import com.myexperience.repository.ExperienceRepository;

@Service
public class ExperienceService
{
	@Autowired
	private ExperienceRepository experienceRepository;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ExperienceService.class);
	
	public Experience add(Experience experience)
	{					
		return experienceRepository.save(experience);
	}
	
	public List<Experience> findAll()
	{
		return this.experienceRepository.findAll();
	}

	public List<Experience> findExperiencesCreatedLastDays(int createdLastDays) {
		DateTime comparaisonDate = new DateTime(new Date());
		LOGGER.info("comparaisonDate" + comparaisonDate + "createdLastDays" + createdLastDays );			
		comparaisonDate= comparaisonDate.minusDays(createdLastDays);
		LOGGER.info("comparaisonDate" + comparaisonDate );
		return this.experienceRepository.findByCreatedDateAfter(comparaisonDate.toDate());
	}

	public List<Experience> findExperiencesByCategory(CategoryType category) {
		return this.experienceRepository.findByCategory(category);
		
	}
	
}
