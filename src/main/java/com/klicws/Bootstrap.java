package com.klicws;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.klicws.model.Comment;
import com.klicws.model.Interest;
import com.klicws.model.Tag;
import com.klicws.model.TypeLocation;
import com.klicws.model.User;
import com.klicws.repository.CommentRepository;
import com.klicws.repository.InterestRepository;
import com.klicws.repository.TagRepository;
import com.klicws.repository.UserRepository;

@Service
public class Bootstrap implements InitializingBean {

	private static Logger logger = Logger.getLogger(Bootstrap.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	InterestRepository interestRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	TagRepository tagRepository;

	@Override
	@Transactional()
	public void afterPropertiesSet() throws Exception {
		logger.info("Bootstrapping data...");

		User user = new User();
		user.setEmail("test@gmail.com");
		user.setPassword("test");
		user = userRepository.saveAndFlush(user);

		Interest interest = new Interest();
		interest.setDate(new Date());
		interest.setDescription("Une station de recyclage");
		interestRepository.saveAndFlush(interest);

		Comment comment = new Comment();
		comment.setText("dhfjkhshk");
		comment = commentRepository.saveAndFlush(comment);

		Tag tag = new Tag();
		tag.setNom("recyclage");
		tag.setInterest(interest);
		tag.setType(TypeLocation.POINT);
		tagRepository.saveAndFlush(tag);

		Interest interest2 = new Interest();
		interest2.setDate(new Date());
		interest2.setDescription("Une billeterie");
		interest2.setTags(new ArrayList<Tag>());
		interest2.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interest2);

		tag.setInterest(interest2);
		interest2.getTags().add(tag);

		comment.setInterest(interest2);
		interest2.getComments().add(comment);
		interestRepository.saveAndFlush(interest2);

		logger.info("...Bootstrapping completed");
	}

}
