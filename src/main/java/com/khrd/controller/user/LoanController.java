package com.khrd.controller.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khrd.service.LoanService;
import com.khrd.service.MemberService;

@RequestMapping("/book/loan/*")
@Controller
public class LoanController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "loaning", method = RequestMethod.GET)
	public String loaningGet(Model model, HttpSession session) {
		logger.info("================ loaning Get =================");
		
		model.addAttribute("titleName", "My Library");
		
		String userid = (String)session.getAttribute("Auth");
		model.addAttribute("member", memberService.selectById(userid));
		model.addAttribute("loan", loanService.readLoaning(userid));
		
		return "/book/loan/loaning";
	}
	
}
