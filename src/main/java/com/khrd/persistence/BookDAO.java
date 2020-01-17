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
	public void insertDetail(BookVO vo);
	public List<BookVO> selectAll();
	public BookVO selectByNo(int bno);
	public void update(BookVO vo);
	public void updateNoImg(BookVO vo);
	public void delete(int bno); // 논리삭제
	public void deleteBookByIsbn(String isbn);
	
	public void updateLoanCnt(String isbn);
	public void updateBookCnt(String isbn);
	
	// BookDetail
	public String selectLastIsbn();
	public BookVO selectByIsbn(String isbn);
	public BookVO findbook(BookVO vo);
	public List<Integer> selectBnobyIsbn(String isbn);
	
	public void deleteBookDetailByIsbn(String isbn);
}
