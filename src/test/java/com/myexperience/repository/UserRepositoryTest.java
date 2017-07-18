package com.myexperience.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.myexperience.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest{
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository userRepository;

    
    @Test
    public void ifRepsitoryIsEmpty() {
        // given
    	List<User> users = userRepository.findAll();
        
        assertThat(users).isEmpty();
    }
    
    
    @Test
    public void saveUser() {
    	User user1 = userRepository.save(new User("sakina", "zilat", "email@hotmmail"));        
        assertThat(user1).hasFieldOrPropertyWithValue("firstName", "sakina");
        
    }
    
    @Ignore
	@Test
	public void findAllUserss() {
		User user1 = new User("sakina", "zilat", "email@hotmmail");
		entityManager.persist(user1);
 
		User user2 = new User("reda", "zilat", "email@hotmmail");
		entityManager.persist(user2);
 
		User user3 = new User("khalid", "zilat", "email@hotmmail");
		entityManager.persist(user3);
 
		List<User> users = userRepository.findAll();
 
		assertThat(users).hasSize(3).contains(user1, user2, user3);
	}
    
}
