package com.khrd.controller.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.khrd.domain.BookVO;
import com.khrd.service.BookService;
import com.khrd.service.LoanService;
import com.khrd.util.UploadFileUtils;

@RequestMapping("/book/*")
@Controller
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Resource(name = "uploadPath") // bean id 값으로 주입(Dependency Injection)을 받음
	private String uploadPath;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	LoanService loanService;
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String homeGet(Model model) {
		logger.info("================ home Get =================");
		
		model.addAttribute("titleName", "Library");
		
		return "/book/home";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public void searchPost(Model model) {
		logger.info("================ search Post =================");
		
		model.addAttribute("titleName", "Search Result");
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public void registerGet(Model model) {
		logger.info("================ register Get =================");
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(d);
		
		model.addAttribute("titleName", "Book Register");
		model.addAttribute("today", today);
		model.addAttribute("booktype", bookService.showBookType());
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPost(BookVO vo, MultipartFile imgfile) throws IOException, Exception {
		logger.info("================ register Post =================");

		if(imgfile != null) {
			String savedName = UploadFileUtils.uploadFile(uploadPath, imgfile.getOriginalFilename(), imgfile.getBytes());

			vo.setImgsrc(savedName);
		}
		bookService.regist(vo);
		
		return "redirect:/book/list";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyGet(Model model, String isbn) {
		logger.info("================ modify Get =================");
		
		model.addAttribute("titleName", "Modify Book");
		model.addAttribute("book", bookService.read(isbn));
		model.addAttribute("booktype", bookService.showBookType());
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPost(BookVO vo) {
		logger.info("================ modify Post =================");
		
		bookService.regist(vo);
		
		return "redirect:/book/read?isbn="+vo.getIsbn();
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public void removeGet(int bno) {
		logger.info("================ remove Get =================");
		
		bookService.delete(bno);
		
	}
	
	@RequestMapping(value = "removeAll", method = RequestMethod.GET)
	public void removeAllGet(String isbn) {
		logger.info("================ remove Get =================");
		
		bookService.deleteAll(isbn);
		
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void read(Model model, String isbn) {
		logger.info("================ read Get =================");
		
		model.addAttribute("titleName", "Read Book");
		
		logger.info("-========================"+bookService.read(isbn));
		model.addAttribute("book", bookService.read(isbn));
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model) {
		logger.info("================ list Get =================");
		
		model.addAttribute("titleName", "Book List");
		model.addAttribute("booklist", bookService.list());
	}
	
}
