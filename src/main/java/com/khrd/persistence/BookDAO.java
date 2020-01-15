package com.khrd.persistence;

import java.util.List;

import com.khrd.domain.BookVO;
import com.khrd.domain.TypeVO;

public interface BookDAO {
	// BookType
	public List<TypeVO> selectAllType();
	public String findType(int btno);
	
	// Book
	public void insert(BookVO vo);
	public void insertDetail(String isbn);
	public List<BookVO> selectAll();
	public BookVO selectByNo(int bno);
	public void update(BookVO vo);
	public void delete(int bno);
	
	public void updateLoanCnt(String isbn);
	public void updateBookCnt(String isbn);
	
	// BookDetail
	public String selectLastIsbn();
	public BookVO selectByIsbn(String isbn);
	public String findbookIsbn(BookVO vo);
	public List<Integer> selectBnobyIsbn(String isbn);
}
