package com.brasajava.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private final String title = "BRASAJAVA HOME PAGE";
	private final String description = "My own java development helper.";
	
	@RequestMapping(value={"/","/home"})
	public String home(Map<String,Object> model){
		model.put("title", title);
		model.put("description",description);
		return "index";
	}

}
