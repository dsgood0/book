package com.khrd.book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khrd.domain.MemberVO;
import com.khrd.domain.TypeVO;
import com.khrd.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {

	@Autowired
	private MemberDAO dao;

	@Test
	public void testInsert() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = sdf.parse("2019-12-13");
		
		MemberVO vo = new MemberVO("user01", "1234", "사용자1", sdate, 1);
		dao.insert(vo);
	}
	
	//@Test
	public void testListAll() {
		dao.selectAll();
	}

	//@Test
	public void testSelectById() {
		dao.selectById("user00");
	}
	
	//@Test
	public void testUpdate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = sdf.parse("2019-12-13");
		
		MemberVO vo = new MemberVO("user00", "1111", "사용자0", sdate, 0);
		dao.update(vo);
	}
	
	//@Test
	public void testSelectAllType() {
		dao.selectAllType();
	}
	
	//@Test	
	public void testChangeType() {
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setMembertype(new TypeVO(3));
		dao.changeType(vo);
	}
	
	//@Test
	public void testchangeAdmin() {
		MemberVO vo = new MemberVO();
		vo.setAdmin(1);
		vo.setUserid("user00");
		dao.changeAdmin(vo);
	}
	
	//@Test
	public void testDelete() {
		dao.delete("user00");
	}
	
	
	
}
