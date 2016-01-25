package com.klicws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klicws.model.User;
import com.klicws.repository.UserRepository;

@RestController
public class UserAPI {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(User user) {

		User connected = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

		return connected;
	}

	@RequestMapping(value = "/subscription", method = RequestMethod.GET)
	public User subscription(User user) {

		User connected = userRepository.save(user);

		return connected;
	}

}
