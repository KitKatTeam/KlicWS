package com.klicws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class HomeController {

	@RequestMapping(method = RequestMethod.GET, value = "")
	public ModelAndView index(Model model) {

		return new ModelAndView("home", "userForm", null);
	}

}
