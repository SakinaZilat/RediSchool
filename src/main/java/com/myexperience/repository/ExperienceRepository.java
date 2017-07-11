package com.myexperience.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexperience.domain.Experience;

import java.util.Date;
import java.util.List;


@Repository("experienceRepository")
public interface ExperienceRepository extends JpaRepository<Experience, Long>
{
    List<Experience> findByCreatedDateAfter(Date curentDate);
}

