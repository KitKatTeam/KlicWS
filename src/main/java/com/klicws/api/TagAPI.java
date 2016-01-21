package com.klicws.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klicws.model.Tag;
import com.klicws.repository.TagRepository;

@RestController
public class TagAPI {

	@Autowired
	private TagRepository tagRepository;

	@RequestMapping(value = "/tag/{idTag}", method = RequestMethod.GET)
	public Tag getTag(@PathVariable("idTag") Long idTag) {

		Tag tag = tagRepository.findOne(idTag);

		return tag;
	}

	@RequestMapping(value = "/tag/update", method = RequestMethod.GET)
	public Tag updateTag(Tag tag) {

		tag = tagRepository.save(tag);

		return tag;
	}

	@RequestMapping(value = "/tag/delete", method = RequestMethod.GET)
	public Boolean deleteTag(Tag tag) {

		tag = tagRepository.getOne(tag.getId());
		tagRepository.delete(tag);

		return true;
	}

	@RequestMapping(value = "/tag/allUnique", method = RequestMethod.GET)
	public List<String> getAllUnique() {

		List<Tag> tags = tagRepository.findAll();
		List<String> tagsS = new ArrayList<String>();
		for (Tag t : tags) {
			if (tagsS.contains(t.getNom())) {
				tagsS.add(t.getNom());
			}
		}

		return tagsS;
	}

}
