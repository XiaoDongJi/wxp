package com.sty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/template/index");
		return view;
	}
}

