package com.klicws.rest;

import java.util.List;

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
public class InterestRest {

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

	@RequestMapping(value = "/interest/{id}/addTag", method = RequestMethod.GET)
	public Interest addTag(@PathVariable("id") Long id, String tagName) {

		Tag tag = new Tag();

		tag.setNom(tagName);
		tag = tagRepository.save(tag);

		Interest interest = interestRepository.findOne(id);
		tag.setInterest(interest);
		interest.getTags().add(tag);
		interestRepository.save(interest);

		return interest;
	}

	@RequestMapping(value = "/interest/{idInterest}/getTags", method = RequestMethod.GET)
	public List<Tag> getTags(@PathVariable("idInterest") Long idInterest) {

		Interest interest = interestRepository.findOne(idInterest);

		return interest.getTags();
	}

}