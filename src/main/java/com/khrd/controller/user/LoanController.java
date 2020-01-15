package com.khrd.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khrd.service.LoanService;

@RequestMapping("/book/loan/*")
@Controller
public class LoanController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	LoanService loanService;
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String homeGet(Model model) {
		logger.info("================ home Get =================");
		
		model.addAttribute("titleName", "Library");
		
		return "/book/home";
	}
	
	
}
