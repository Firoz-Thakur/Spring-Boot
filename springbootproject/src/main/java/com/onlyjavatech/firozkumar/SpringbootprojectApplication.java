package com.onlyjavatech.firozkumar;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.onlyjavatech.firozkumar.dao.UserRepository;

import entities.User;

@SpringBootApplication
public class SpringbootprojectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =    SpringApplication.run(SpringbootprojectApplication.class, args);
		UserRepository userRepository =context.getBean(UserRepository.class);
		User user = new User();
		user.setName("firoz");
		user.setId(1);
		user.setCity("mandi");
		user.setStatus("I am java progammert");
		User user2 = userRepository.save(user);
		System.out.println(user2);
	}

}
