package com.myexperience.service;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		String experienceBody = experience.getBody();
		if (experienceBody.length() > 50)
		{
			DateTime dTime=new DateTime(new Date());
			experience.setCreatedDate(dTime.toDate());
			LOGGER.info("The Current Date to Add new User is: "+dTime.toString());
			experienceRepository.save(experience);
		}
		return experience;
	}
	
	public List<Experience> findAll()
	{
		return this.experienceRepository.findAll();
	}

	public List<Experience> findByStartDateAfter(int comparasionDate){
		DateTime dTime=new DateTime(new Date());
		LOGGER.info("The Current Date "+dTime.toString()+" How many Day befor "+comparasionDate);
		dTime=dTime.minusDays(comparasionDate);
		LOGGER.info("Date after change "+dTime.toString());
		return this.experienceRepository.findByCreatedDateAfter(dTime.toDate());
	}

}
