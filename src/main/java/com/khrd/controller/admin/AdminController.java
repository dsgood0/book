package com.khrd.controller.admin;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khrd.service.MemberService;

@RequestMapping("/admin/*")
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "changeAdmin", method = RequestMethod.GET)
	public void changeAdmin(Model model, HttpSession session) {
		logger.info("================ changeAdmin Get =================");
		
	}
	
	@RequestMapping(value = "changeMemberType", method = RequestMethod.GET)
	public void changeMemberType(Model model, HttpSession session) {
		logger.info("================ changeMemberType Get =================");
		
	}
	
	@RequestMapping(value = "withdraw", method = RequestMethod.GET)
	public void withdraw(Model model, HttpSession session) {
		logger.info("================ withdraw Get =================");
		
	}
	
}
