package com.daliu.classtime.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.models.Model;

@Controller
@RequestMapping("/classtime")
public class indexControl {
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
	}
}
