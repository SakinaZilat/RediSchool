package com.myexperience.controller;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	@Autowired
    private UserController userController;

    @Test
    public void contexLoads() throws Exception {
        /*we use here assertj*/
    	assertThat(userController).isNotNull();
    }

}
