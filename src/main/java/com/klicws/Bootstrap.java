package com.klicws;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.klicws.model.User;
import com.klicws.repository.UserRepository;

@Service
public class Bootstrap implements InitializingBean {

	private static Logger logger = Logger.getLogger(Bootstrap.class);

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional()
	public void afterPropertiesSet() throws Exception {
		logger.info("Bootstrapping data...");

		User user = new User();
		user.setEmail("test@gmail.com");
		user.setPassword("test");
		userRepository.save(user);

		logger.info("...Bootstrapping completed");
	}

}
