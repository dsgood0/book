package com.khrd.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khrd.domain.BookVO;
import com.khrd.domain.TypeVO;
import com.khrd.persistence.BookDAO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO dao;

	@Override
	public List<TypeVO> showBookType() {
		return dao.selectAllType();
	}

	@Transactional
	@Override
	public void regist(BookVO vo) {
		String isbn;

		// 같은 제목, 같은 저자, 같은 출판사의 책이 있을 경우
		if (dao.findbookIsbn(vo) != null) {
			isbn = dao.findbookIsbn(vo);
		} else { 
			String type = dao.findType(vo.getBooktype().getNo());
			
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String date = sdf.format(d);
			
			isbn = type + date + vo.getIsbn();
			vo.setIsbn(isbn);
			dao.insert(vo);
		}
		dao.insertDetail(isbn);
		dao.updateBookCnt(isbn);
	}

	@Override
	public List<BookVO> list() {
		return dao.selectAll();
	}

	@Override
	public BookVO read(String isbn) {
		return dao.selectByIsbn(isbn);
	}

	@Override
	public void update(BookVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(int bno) {
		dao.delete(bno);
	}

	@Transactional
	@Override
	public void deleteAll(String isbn) {
		List<Integer> bnos = dao.selectBnobyIsbn(isbn);
		
		for(int i=0; i<bnos.size(); i++) {
			dao.delete(bnos.get(i));
		}
		
	}

}
