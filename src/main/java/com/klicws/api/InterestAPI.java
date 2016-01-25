package com.klicws.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klicws.model.Comment;
import com.klicws.model.Interest;
import com.klicws.model.Tag;
import com.klicws.repository.CommentRepository;
import com.klicws.repository.InterestRepository;
import com.klicws.repository.TagRepository;

@RestController
public class InterestAPI {

	@Autowired
	private InterestRepository interestRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private TagRepository tagRepository;

	@RequestMapping(value = "/interest/all", method = RequestMethod.GET)
	public List<Interest> getAll() {

		List<Interest> interests = interestRepository.findAll();

		return interests;
	}

	@RequestMapping(value = "/interest/add", method = RequestMethod.GET)
	public Interest add(Interest interest) {
		interest.setDate(new Date());
		return interestRepository.save(interest);
	}

	@RequestMapping(value = "/interest/udpate", method = RequestMethod.GET)
	public Interest update(@PathVariable("id") Long id, Interest interest) {

		Interest interestLocal = interestRepository.getOne(id);
		interestLocal.setDescription(interest.getDescription());
		interestLocal.setImage(interest.getImage());
		interestLocal.setPositionX(interest.getPositionX());
		interestLocal.setPositionY(interest.getPositionY());

		return interestRepository.save(interest);
	}

	@RequestMapping(value = "/interest/{id}", method = RequestMethod.GET)
	public Interest add(@PathVariable("id") Long id) {

		return interestRepository.findOne(id);
	}

	@RequestMapping(value = "/interest/delete", method = RequestMethod.GET)
	public Boolean remove(Long id) {

		Interest interest = interestRepository.findOne(id);

		if (interest != null) {
			interestRepository.delete(interest);
		}

		return (interest != null);

	}

	@RequestMapping(value = "/interest/{id}/addComment", method = RequestMethod.GET)
	public Interest addComment(@PathVariable("id") Long id, String text) {

		Comment comment = new Comment();

		comment.setText(text);
		comment = commentRepository.save(comment);

		Interest interest = interestRepository.findOne(id);
		comment.setInterest(interest);
		interest.getComments().add(comment);
		interestRepository.save(interest);

		return interest;
	}

	@RequestMapping(value = "/interest/{idInterest}/addTag", method = RequestMethod.GET)
	public Interest addTag(@PathVariable("idInterest") Long id, Tag tag) {

		tag = tagRepository.save(tag);

		Interest interest = interestRepository.findOne(id);
		tag.setInterest(interest);
		interest.getTags().add(tag);
		interestRepository.save(interest);

		return interest;
	}

	@RequestMapping(value = "/interest/{idInterest}/tags", method = RequestMethod.GET)
	public List<Tag> getTags(@PathVariable("idInterest") Long idInterest) {

		Interest interest = interestRepository.findOne(idInterest);

		return interest.getTags();
	}

	@RequestMapping(value = "/interest/getByTags", method = RequestMethod.GET)
	public List<Interest> findByTags(String[] keys) {
		List<Interest> interests = interestRepository.findAll();
		List<Interest> interestsToReturn = new ArrayList<Interest>();
		Set<Long> ids = new HashSet<Long>();
		for (String k : keys) {
			for (Interest i : interests) {
				for (Tag t : i.getTags()) {
					if (!ids.contains(t.getId()) && t.getNom().equals(k)) {
						ids.add(t.getId());
						interestsToReturn.add(i);
					}
				}
			}

		}

		return interestsToReturn;
	}

}
