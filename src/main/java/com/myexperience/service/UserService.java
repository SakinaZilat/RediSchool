package com.myexperience.service;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexperience.domain.User;
import com.myexperience.repository.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	public User add(User user)	
	{
		String upperCaseName = user.getFirstName().toUpperCase();
		user.setFirstName(upperCaseName);
		// or we can do it this way
		user.setLastName(user.getLastName().toUpperCase());
		DateTime dTime=new DateTime(new Date());
		user.setRegistredDate(dTime.toDate());

		LOGGER.info("The Current Date to Add new User is: "+dTime.toString());
		return this.userRepository.save(user);
	}
	public List<User> findAll()
	{
		return this.userRepository.findAll();
	}
	
	public User findUserByEmail(String email)
	{
		return this.userRepository.findByEmail(email);
	}
	public List<User> findUsersByLastName(String lastName)
	{
		return this.userRepository.findByLastName(lastName.toUpperCase());
	}
	public List<User> findUsersByLastNameAndFistName(String lastName, String firstName)
	{

		return this.userRepository.findByLastNameAndFirstName(lastName.toUpperCase(), firstName.toUpperCase());
	}

	public Boolean login(String userName,String passWord){
		List<User> userfound= userRepository.findByUserNameAndPassWord(userName,passWord);
		if (userfound.size()>= 1)
			return true;
		else
			return false;
		}
}
