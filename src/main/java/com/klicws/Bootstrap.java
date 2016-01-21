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

		// Real interest
		// Latitude: 43.5629 | Longitude: 1.462807
		Interest interestR = new Interest();
		interestR.setPositionX(43.562F);
		interestR.setPositionY(1.462807F);
		interestR.setDate(new Date());
		interestR.setDescription("Poubelle pour le verre");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.56356 | Longitude: 1.460447
		interestR = new Interest();
		interestR.setPositionX(43.56356F);
		interestR.setPositionY(1.460447F);
		interestR.setDate(new Date());
		interestR.setDescription("Poubelle pour le verre");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.563483 | Longitude: 1.460318
		interestR = new Interest();
		interestR.setPositionX(43.563483F);
		interestR.setPositionY(1.460318F);
		interestR.setDate(new Date());
		interestR.setDescription("Recyclage textile");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.560333 | Longitude: 1.457459
		interestR = new Interest();
		interestR.setPositionX(43.560333F);
		interestR.setPositionY(1.457459F);
		interestR.setDate(new Date());
		interestR.setDescription("Recyclage verre");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.561405 | Longitude: 1.456858
		interestR = new Interest();
		interestR.setPositionX(43.561405F);
		interestR.setPositionY(1.456858F);
		interestR.setDate(new Date());
		interestR.setDescription("Recyclage verre");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.567657 | Longitude: 1.464395
		interestR = new Interest();
		interestR.setPositionX(43.567657F);
		interestR.setPositionY(1.464395F);
		interestR.setDate(new Date());
		interestR.setDescription("Recyclage verre");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.567059 | Longitude: 1.467442
		interestR = new Interest();
		interestR.setPositionX(43.567059F);
		interestR.setPositionY(1.467442F);
		interestR.setDate(new Date());
		interestR.setDescription("Recyclage verre");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.565108 | Longitude: 1.469384
		interestR = new Interest();
		interestR.setPositionX(43.565108F);
		interestR.setPositionY(1.469384F);
		interestR.setDate(new Date());
		interestR.setDescription("Recyclage verre");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.564213 | Longitude: 1.470489
		interestR = new Interest();
		interestR.setPositionX(43.564213F);
		interestR.setPositionY(1.470489F);
		interestR.setDate(new Date());
		interestR.setDescription("Recyclage verre");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.561127 | Longitude: 1.463826
		interestR = new Interest();
		interestR.setPositionX(43.561127F);
		interestR.setPositionY(1.463826F);
		interestR.setDate(new Date());
		interestR.setDescription("Recyclage papiers");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// just add tag
		Tag tag = new Tag();
		tag.setNom("recyclage");
		tag.setInterest(interestR);
		tag.setType(TypeLocation.POINT);
		tagRepository.saveAndFlush(tag);

		tag.setInterest(interestR);
		interestR.getTags().add(tag);
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.562068 | Longitude: 1.469845
		interestR = new Interest();
		interestR.setPositionX(43.562068F);
		interestR.setPositionY(1.469845F);
		interestR.setDate(new Date());
		interestR.setDescription("Recyclage papiers");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// just add tag
		tag = new Tag();
		tag.setNom("recyclage");
		tag.setInterest(interestR);
		tag.setType(TypeLocation.POINT);
		tagRepository.saveAndFlush(tag);

		tag.setInterest(interestR);
		interestR.getTags().add(tag);
		interestRepository.saveAndFlush(interestR);

		// Latitude: 43.563747 | Longitude: 1.4655
		interestR = new Interest();
		interestR.setPositionX(43.563747F);
		interestR.setPositionY(1.4655F);
		interestR.setDate(new Date());
		interestR.setDescription("Recyclage piles");
		interestR.setTags(new ArrayList<Tag>());
		interestR.setComments(new ArrayList<Comment>());
		interestRepository.saveAndFlush(interestR);

		// just add tag
		tag = new Tag();
		tag.setNom("recyclage");
		tag.setInterest(interestR);
		tag.setType(TypeLocation.POINT);
		tagRepository.saveAndFlush(tag);

		tag.setInterest(interestR);
		interestR.getTags().add(tag);
		interestRepository.saveAndFlush(interestR);

		logger.info("...Bootstrapping completed");
	}

}
