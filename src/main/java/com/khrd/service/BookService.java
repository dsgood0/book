package com.khrd.service;

import java.util.List;

import com.khrd.domain.BookVO;
import com.khrd.domain.TypeVO;

public interface BookService {
	public List<TypeVO> showBookType();
	
	public void regist(BookVO vo);
	public List<BookVO> list();
	public BookVO read(String isbn);
	public void update(BookVO vo);
	public void updateNoImage(BookVO vo);
	public void delete(int bno);
	public void deleteAll(String isbn);
}
