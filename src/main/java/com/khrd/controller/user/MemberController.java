package com.khrd.controller.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khrd.domain.MemberVO;
import com.khrd.service.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String LoginGet(Model model) {
		logger.info("================ login Get =================");
		
		model.addAttribute("titleName", "Login");
		
		return "/member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String LoginPost(Model model, MemberVO vo, HttpSession session) {
		logger.info("================ login Post =================");
		
		String rtn = "redirect:/member/login";
		
		String userid = vo.getUserid();
		String userpw = vo.getUserpw();
		
		MemberVO member = service.selectById(userid);
		
		if(member == null) {
			model.addAttribute("msg", "존재하지 않는 아이디입니다.");
		} else {
			if(member.getUserpw().equals(userpw)) {
				if(member.getWithdraw() == 1) {
					model.addAttribute("msg", "탈퇴한 회원입니다.");
				} else {
					session.setAttribute("Auth", userid);
					rtn = "redirect:/book/home";
				}
			} else {
				model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			}
		}
		return rtn;
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String JoinGet(Model model) {
		logger.info("================ join Get =================");
		
		model.addAttribute("titleName", "Join");
		
		return "/member/join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String JoinPost(Model model, MemberVO vo) {
		logger.info("================ join Post =================");
		
		model.addAttribute("titleName", "Join");
		
		service.regist(vo);
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyGet(Model model, HttpSession session) {
		logger.info("================ modify Get =================");
		
		model.addAttribute("titleName", "Modify Member");
		
		String userid = (String) session.getAttribute("Auth");
		
		model.addAttribute("member", service.selectById(userid));
		
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPost(MemberVO vo, HttpSession session) {
		logger.info("================ modify Post =================");
		
		String userid = (String)session.getAttribute("Auth");
		vo.setUserid(userid);
		service.modify(vo);

		return "redirect:/member/detail";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detailGet(Model model, HttpSession session) {
		logger.info("================ detail Get =================");
		
		model.addAttribute("titleName", "Member Detail");
		
		String Auth = (String) session.getAttribute("Auth");
		
		model.addAttribute("member", service.selectById(Auth));
	}
	
	@RequestMapping(value = "withdraw", method = RequestMethod.GET)
	public void withdrawGet(Model model, HttpSession session) {
		logger.info("================ withdraw Get =================");
		
		model.addAttribute("titleName", "Member Withdraw");
		
		String Auth = (String) session.getAttribute("Auth");
		
		model.addAttribute("member", service.selectById(Auth));
	}
	
	@RequestMapping(value = "withdraw", method = RequestMethod.POST)
	public String withdrawPost(Model model, HttpSession session, String userpw, 
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("================ withdraw Post =================");
		
		String rtn = "/member/withdraw";
		
		String Auth = (String) session.getAttribute("Auth");
		
		MemberVO member = service.selectById(Auth);
		
		if(member.getUserpw().equals(userpw)) {
			service.withdraw(Auth);
			session.invalidate();
			rtn = "redirect:/book/home";
		} else {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("member", service.selectById(Auth));
		}
		return rtn;
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logoutGet(HttpSession session) {
		logger.info("================ logout Get =================");
		
		String Auth = (String) session.getAttribute("Auth");
		
		if(Auth != null) {
			session.invalidate();
		}
		return "redirect:/book/home";
	}
	
	@RequestMapping(value = "idcheck", method = RequestMethod.GET)
	public ResponseEntity<String> idcheckGet(String userid, Model model) {
		logger.info("================ idcheck Get =================");

		ResponseEntity<String> res = null;
		
		MemberVO vo = service.selectById(userid);
		if(vo != null) {
			res = new ResponseEntity<String>("fail", HttpStatus.OK);
		} else {
			res = new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return res;
	}
	
}
