package com.myexperience.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexperience.domain.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>
{	
	User findByEmail(String email);
	
	List<User> findByLastName(String lastname);
	
	List<User> findByLastNameAndFirstName(String lastname, String firstname);

	List<User> findByUserNameAndPassWord(String user,String passWord);
}

