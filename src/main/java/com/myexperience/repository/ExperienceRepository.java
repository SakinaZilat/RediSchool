package com.myexperience.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexperience.domain.CategoryType;
import com.myexperience.domain.Experience;


@Repository("experienceRepository")
public interface ExperienceRepository extends JpaRepository<Experience, Long>
{

	List<Experience> findByCreatedDateAfter(Date createdLastDays);

	List<Experience> findByCategory(CategoryType category);
	

}

