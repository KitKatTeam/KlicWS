package com.klicws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klicws.model.User;
import com.klicws.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(User user) {

		User connected = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

		return connected;
	}

}
