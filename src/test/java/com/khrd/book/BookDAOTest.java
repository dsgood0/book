package com.khrd.book;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khrd.domain.BookTypeVO;
import com.khrd.domain.BookVO;
import com.khrd.persistence.BookDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BookDAOTest {

	@Autowired
	private BookDAO dao;

	//@Test
	public void testInsert() throws ParseException {
		BookTypeVO bt = new BookTypeVO();
		bt.setNo(1);
		
		BookVO vo = new BookVO("AA000003", "우리가 빛의 속도로 갈 수 없다면", 
				"한국과학문학상 수상 작가, 과학도 김초엽의 첫 소설!", "김초엽", "허블", null, bt);
		dao.insert(vo);
	}
	
	@Test
	public void testSelectByIsbn() {
		dao.selectByIsbn("AA000003");
	}

	//@Test
	public void testSelectByNo() {
		dao.selectByNo(1);
	}
	
	//@Test
	public void testUpdate() throws ParseException {
		BookTypeVO bt = new BookTypeVO();
		bt.setNo(3);
		BookVO vo = new BookVO("AA000003", "변경된 제목", "수정된 내용", "김초림", "허블망원경", "modify.jpg", bt);
		dao.update(vo);
	}
	
	//@Test
	public void testSelectAllType() {
		dao.selectAllType();
	}
	
	//@Test
	public void testDelete() {
		dao.delete(1);
	}
	
	
	
}
