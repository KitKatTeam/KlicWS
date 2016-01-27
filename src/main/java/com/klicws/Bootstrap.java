package com.klicws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
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
		user.setUsername("testeur");
		user = userRepository.saveAndFlush(user);

		// VERRE
		List<Point> verreList = new ArrayList<Point>();
		verreList.add(new Point(43.55891, 1.47303));
		verreList.add(new Point(43.55995, 1.47195));
		verreList.add(new Point(43.55995, 1.47195));
		verreList.add(new Point(43.56439, 1.47053));
		verreList.add(new Point(43.56355, 1.47579));
		verreList.add(new Point(43.55509, 1.46816));
		verreList.add(new Point(43.56295, 1.46311));
		verreList.add(new Point(43.56305, 1.45939));
		verreList.add(new Point(43.56068, 1.45738));
		verreList.add(new Point(43.56376, 1.45531));
		verreList.add(new Point(43.56850, 1.46620));
		verreList.add(new Point(43.56735, 1.46726));
		verreList.add(new Point(43.57124, 1.46269));
		verreList.add(new Point(43.56731, 1.46477));

		for (Point p : verreList) {
			Interest interestR = new Interest();
			Double x = p.getX();
			interestR.setPositionX(x.floatValue());
			Double y = p.getY();
			interestR.setPositionY(y.floatValue());
			interestR.setDate(new Date());
			interestR.setDescription("Recyclage verre");
			interestR.setTags(new ArrayList<Tag>());
			interestR.setComments(new ArrayList<Comment>());
			interestR.setUserId(1L);
			interestRepository.saveAndFlush(interestR);

			// just add tag
			Tag tag = new Tag();
			tag.setNom("verre");
			tag.setInterest(interestR);
			tag.setType(TypeLocation.POINT);

			tagRepository.saveAndFlush(tag);

			tag.setInterest(interestR);
			interestR.getTags().add(tag);
			interestRepository.saveAndFlush(interestR);
		}

		List<Point> textileList = new ArrayList<Point>();
		textileList.add(new Point(43.55505, 1.46811));
		textileList.add(new Point(43.56305, 1.45935));

		for (Point p : textileList) {
			Interest interestR = new Interest();
			Double x = p.getX();
			interestR.setPositionX(x.floatValue());
			Double y = p.getY();
			interestR.setPositionY(y.floatValue());
			interestR.setDate(new Date());
			interestR.setDescription("Recyclage textile");
			interestR.setTags(new ArrayList<Tag>());
			interestR.setComments(new ArrayList<Comment>());
			interestR.setUserId(1L);
			interestRepository.saveAndFlush(interestR);

			// just add tag
			Tag tag = new Tag();
			tag.setNom("textile");
			tag.setInterest(interestR);
			tag.setType(TypeLocation.POINT);

			tagRepository.saveAndFlush(tag);

			tag.setInterest(interestR);
			interestR.getTags().add(tag);
			interestRepository.saveAndFlush(interestR);
		}

		List<Point> cartonList = new ArrayList<Point>();

		cartonList.add(new Point(43.56665, 1.4695));
		cartonList.add(new Point(43.56674, 1.46968));
		cartonList.add(new Point(43.56657, 1.46985));
		cartonList.add(new Point(43.5665, 1.46965));

		cartonList.add(new Point(43.56577, 1.46736));
		cartonList.add(new Point(43.56593, 1.46769));
		cartonList.add(new Point(43.56577, 1.46785));
		cartonList.add(new Point(43.5656, 1.46753));

		cartonList.add(new Point(43.56449, 1.4656));
		cartonList.add(new Point(43.56455, 1.46576));
		cartonList.add(new Point(43.56406, 1.46625));
		cartonList.add(new Point(43.56398, 1.46609));

		cartonList.add(new Point(43.5622, 1.46751));
		cartonList.add(new Point(43.56231, 1.4677));
		cartonList.add(new Point(43.56206, 1.46795));
		cartonList.add(new Point(43.56197, 1.46772));

		cartonList.add(new Point(43.55773, 1.46920));
		cartonList.add(new Point(43.55780, 1.46934));
		cartonList.add(new Point(43.55745, 1.46969));
		cartonList.add(new Point(43.55738, 1.46954));

		cartonList.add(new Point(43.55992, 1.47172));
		cartonList.add(new Point(43.56000, 1.47186));
		cartonList.add(new Point(43.55948, 1.47236));
		cartonList.add(new Point(43.55942, 1.47220));

		for (Point p : cartonList) {
			Interest interestR = new Interest();
			Double x = p.getX();
			interestR.setPositionX(x.floatValue());
			Double y = p.getY();
			interestR.setPositionY(y.floatValue());
			interestR.setDate(new Date());
			interestR.setDescription("Recyclage carton");
			interestR.setTags(new ArrayList<Tag>());
			interestR.setComments(new ArrayList<Comment>());
			interestR.setUserId(1L);
			interestRepository.saveAndFlush(interestR);

			// just add tag
			Tag tag = new Tag();
			tag.setNom("carton");
			tag.setInterest(interestR);
			tag.setType(TypeLocation.POINT);

			tagRepository.saveAndFlush(tag);

			tag.setInterest(interestR);
			interestR.getTags().add(tag);
			interestRepository.saveAndFlush(interestR);
		}

		List<Point> cartonPile = new ArrayList<Point>();

		cartonPile.add(new Point(43.56456, 1.46589));
		cartonPile.add(new Point(43.56472, 1.46617));
		cartonPile.add(new Point(43.56458, 1.46629));
		cartonPile.add(new Point(43.56446, 1.46602));

		cartonPile.add(new Point(43.56362, 1.46487));
		cartonPile.add(new Point(43.56381, 1.46537));
		cartonPile.add(new Point(43.56354, 1.4657));
		cartonPile.add(new Point(43.5633, 1.46522));

		for (Point p : cartonPile) {
			Interest interestR = new Interest();
			Double x = p.getX();
			interestR.setPositionX(x.floatValue());
			Double y = p.getY();
			interestR.setPositionY(y.floatValue());
			interestR.setDate(new Date());
			interestR.setDescription("Recyclage pile");
			interestR.setTags(new ArrayList<Tag>());
			interestR.setComments(new ArrayList<Comment>());
			interestR.setUserId(1L);
			interestRepository.saveAndFlush(interestR);

			// just add tag
			Tag tag = new Tag();
			tag.setNom("pile");
			tag.setInterest(interestR);
			tag.setType(TypeLocation.POINT);

			tagRepository.saveAndFlush(tag);

			tag.setInterest(interestR);
			interestR.getTags().add(tag);
			interestRepository.saveAndFlush(interestR);
		}

		List<Point> cartonPapier = new ArrayList<Point>();

		cartonPapier.add(new Point(43.56377, 1.46168));
		cartonPapier.add(new Point(43.56384, 1.46181));
		cartonPapier.add(new Point(43.56375, 1.46195));
		cartonPapier.add(new Point(43.56367, 1.4618));

		cartonPapier.add(new Point(43.5632, 1.465620));
		cartonPapier.add(new Point(43.56335, 1.4659));
		cartonPapier.add(new Point(43.56263, 1.46661));
		cartonPapier.add(new Point(43.56249, 1.46632));

		cartonPapier.add(new Point(43.56349, 1.46428));
		cartonPapier.add(new Point(43.56349, 1.46428));
		cartonPapier.add(new Point(43.56323, 1.46499));
		cartonPapier.add(new Point(43.56311, 1.46473));

		cartonPapier.add(new Point(43.56542, 1.46363));
		cartonPapier.add(new Point(43.56393, 1.46529));
		cartonPapier.add(new Point(43.56426, 1.46496));
		cartonPapier.add(new Point(43.56403, 1.46448));

		cartonPapier.add(new Point(43.56497, 1.46513));
		cartonPapier.add(new Point(43.56504, 1.46529));
		cartonPapier.add(new Point(43.56461, 1.4657));
		cartonPapier.add(new Point(43.56454, 1.46554));

		cartonPapier.add(new Point(43.56666, 1.46950));
		cartonPapier.add(new Point(43.56674, 1.46967));
		cartonPapier.add(new Point(43.56667, 1.46975));
		cartonPapier.add(new Point(43.56657, 1.46958));

		cartonPapier.add(new Point(43.56758, 1.46950));
		cartonPapier.add(new Point(43.56773, 1.46989));
		cartonPapier.add(new Point(43.56733, 1.47026));
		cartonPapier.add(new Point(43.56716, 1.46991));

		for (Point p : cartonPapier) {
			Interest interestR = new Interest();
			Double x = p.getX();
			interestR.setPositionX(x.floatValue());
			Double y = p.getY();
			interestR.setPositionY(y.floatValue());
			interestR.setDate(new Date());
			interestR.setDescription("Recyclage papier");
			interestR.setTags(new ArrayList<Tag>());
			interestR.setComments(new ArrayList<Comment>());
			interestR.setUserId(1L);
			interestRepository.saveAndFlush(interestR);

			// just add tag
			Tag tag = new Tag();
			tag.setNom("papier");
			tag.setInterest(interestR);
			tag.setType(TypeLocation.POINT);

			tagRepository.saveAndFlush(tag);

			tag.setInterest(interestR);
			interestR.getTags().add(tag);
			interestRepository.saveAndFlush(interestR);
		}

		logger.info("...Bootstrapping completed");
	}

}
